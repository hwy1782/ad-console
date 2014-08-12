package bootstrapUi


import grails.test.mixin.*
import spock.lang.*

@TestFor(BootstrapUIController)
@Mock(BootstrapUI)
class BootstrapUIControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when: "The index action is executed"
        controller.index()

        then: "The model is correct"
        !model.bootstrapUIInstanceList
        model.bootstrapUIInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when: "The create action is executed"
        controller.create()

        then: "The model is correctly created"
        model.bootstrapUIInstance != null
    }

    void "Test the save action correctly persists an instance"() {

        when: "The save action is executed with an invalid instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'POST'
        def bootstrapUI = new BootstrapUI()
        bootstrapUI.validate()
        controller.save(bootstrapUI)

        then: "The create view is rendered again with the correct model"
        model.bootstrapUIInstance != null
        view == 'create'

        when: "The save action is executed with a valid instance"
        response.reset()
        populateValidParams(params)
        bootstrapUI = new BootstrapUI(params)

        controller.save(bootstrapUI)

        then: "A redirect is issued to the show action"
        response.redirectedUrl == '/bootstrapUI/show/1'
        controller.flash.message != null
        BootstrapUI.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when: "The show action is executed with a null domain"
        controller.show(null)

        then: "A 404 error is returned"
        response.status == 404

        when: "A domain instance is passed to the show action"
        populateValidParams(params)
        def bootstrapUI = new BootstrapUI(params)
        controller.show(bootstrapUI)

        then: "A model is populated containing the domain instance"
        model.bootstrapUIInstance == bootstrapUI
    }

    void "Test that the edit action returns the correct model"() {
        when: "The edit action is executed with a null domain"
        controller.edit(null)

        then: "A 404 error is returned"
        response.status == 404

        when: "A domain instance is passed to the edit action"
        populateValidParams(params)
        def bootstrapUI = new BootstrapUI(params)
        controller.edit(bootstrapUI)

        then: "A model is populated containing the domain instance"
        model.bootstrapUIInstance == bootstrapUI
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when: "Update is called for a domain instance that doesn't exist"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'PUT'
        controller.update(null)

        then: "A 404 error is returned"
        response.redirectedUrl == '/bootstrapUI/index'
        flash.message != null


        when: "An invalid domain instance is passed to the update action"
        response.reset()
        def bootstrapUI = new BootstrapUI()
        bootstrapUI.validate()
        controller.update(bootstrapUI)

        then: "The edit view is rendered again with the invalid instance"
        view == 'edit'
        model.bootstrapUIInstance == bootstrapUI

        when: "A valid domain instance is passed to the update action"
        response.reset()
        populateValidParams(params)
        bootstrapUI = new BootstrapUI(params).save(flush: true)
        controller.update(bootstrapUI)

        then: "A redirect is issues to the show action"
        response.redirectedUrl == "/bootstrapUI/show/$bootstrapUI.id"
        flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when: "The delete action is called for a null instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'DELETE'
        controller.delete(null)

        then: "A 404 is returned"
        response.redirectedUrl == '/bootstrapUI/index'
        flash.message != null

        when: "A domain instance is created"
        response.reset()
        populateValidParams(params)
        def bootstrapUI = new BootstrapUI(params).save(flush: true)

        then: "It exists"
        BootstrapUI.count() == 1

        when: "The domain instance is passed to the delete action"
        controller.delete(bootstrapUI)

        then: "The instance is deleted"
        BootstrapUI.count() == 0
        response.redirectedUrl == '/bootstrapUI/index'
        flash.message != null
    }
}
