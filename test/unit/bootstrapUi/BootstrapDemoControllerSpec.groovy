package bootstrapUi


import grails.test.mixin.*
import spock.lang.*

@TestFor(BootstrapDemoController)
@Mock(BootstrapUI)
class BootstrapDemoControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when: "The index action is executed"
        controller.index()

        then: "The model is correct"
        !model.bootstrapDemoInstanceList
        model.bootstrapDemoInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when: "The create action is executed"
        controller.create()

        then: "The model is correctly created"
        model.bootstrapDemoInstance != null
    }

    void "Test the save action correctly persists an instance"() {

        when: "The save action is executed with an invalid instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'POST'
        def bootstrapDemo = new BootstrapUI()
        bootstrapDemo.validate()
        controller.save(bootstrapDemo)

        then: "The create view is rendered again with the correct model"
        model.bootstrapDemoInstance != null
        view == 'create'

        when: "The save action is executed with a valid instance"
        response.reset()
        populateValidParams(params)
        bootstrapDemo = new BootstrapUI(params)

        controller.save(bootstrapDemo)

        then: "A redirect is issued to the show action"
        response.redirectedUrl == '/bootstrapDemo/show/1'
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
        def bootstrapDemo = new BootstrapUI(params)
        controller.show(bootstrapDemo)

        then: "A model is populated containing the domain instance"
        model.bootstrapDemoInstance == bootstrapDemo
    }

    void "Test that the edit action returns the correct model"() {
        when: "The edit action is executed with a null domain"
        controller.edit(null)

        then: "A 404 error is returned"
        response.status == 404

        when: "A domain instance is passed to the edit action"
        populateValidParams(params)
        def bootstrapDemo = new BootstrapUI(params)
        controller.edit(bootstrapDemo)

        then: "A model is populated containing the domain instance"
        model.bootstrapDemoInstance == bootstrapDemo
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when: "Update is called for a domain instance that doesn't exist"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'PUT'
        controller.update(null)

        then: "A 404 error is returned"
        response.redirectedUrl == '/bootstrapDemo/index'
        flash.message != null


        when: "An invalid domain instance is passed to the update action"
        response.reset()
        def bootstrapDemo = new BootstrapUI()
        bootstrapDemo.validate()
        controller.update(bootstrapDemo)

        then: "The edit view is rendered again with the invalid instance"
        view == 'edit'
        model.bootstrapDemoInstance == bootstrapDemo

        when: "A valid domain instance is passed to the update action"
        response.reset()
        populateValidParams(params)
        bootstrapDemo = new BootstrapUI(params).save(flush: true)
        controller.update(bootstrapDemo)

        then: "A redirect is issues to the show action"
        response.redirectedUrl == "/bootstrapDemo/show/$bootstrapDemo.id"
        flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when: "The delete action is called for a null instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'DELETE'
        controller.delete(null)

        then: "A 404 is returned"
        response.redirectedUrl == '/bootstrapDemo/index'
        flash.message != null

        when: "A domain instance is created"
        response.reset()
        populateValidParams(params)
        def bootstrapDemo = new BootstrapUI(params).save(flush: true)

        then: "It exists"
        BootstrapUI.count() == 1

        when: "The domain instance is passed to the delete action"
        controller.delete(bootstrapDemo)

        then: "The instance is deleted"
        BootstrapUI.count() == 0
        response.redirectedUrl == '/bootstrapDemo/index'
        flash.message != null
    }
}
