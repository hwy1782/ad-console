package bootstrapUi


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class BootstrapUIController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond BootstrapUI.list(params), model: [bootstrapUIInstanceCount: BootstrapUI.count()]
    }

    def show(BootstrapUI bootstrapUIInstance) {
        respond bootstrapUIInstance
    }

    def create() {
        respond new BootstrapUI(params)
    }

    @Transactional
    def save(BootstrapUI bootstrapUIInstance) {
        if (bootstrapUIInstance == null) {
            notFound()
            return
        }

        if (bootstrapUIInstance.hasErrors()) {
            respond bootstrapUIInstance.errors, view: 'create'
            return
        }

        bootstrapUIInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'bootstrapUI.label', default: 'BootstrapUI'), bootstrapUIInstance.id])
                redirect bootstrapUIInstance
            }
            '*' { respond bootstrapUIInstance, [status: CREATED] }
        }
    }

    def edit(BootstrapUI bootstrapUIInstance) {
        respond bootstrapUIInstance
    }

    @Transactional
    def update(BootstrapUI bootstrapUIInstance) {
        if (bootstrapUIInstance == null) {
            notFound()
            return
        }

        if (bootstrapUIInstance.hasErrors()) {
            respond bootstrapUIInstance.errors, view: 'edit'
            return
        }

        bootstrapUIInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'BootstrapUI.label', default: 'BootstrapUI'), bootstrapUIInstance.id])
                redirect bootstrapUIInstance
            }
            '*' { respond bootstrapUIInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(BootstrapUI bootstrapUIInstance) {

        if (bootstrapUIInstance == null) {
            notFound()
            return
        }

        bootstrapUIInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'BootstrapUI.label', default: 'BootstrapUI'), bootstrapUIInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'bootstrapUI.label', default: 'BootstrapUI'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
