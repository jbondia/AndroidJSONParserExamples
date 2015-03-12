package simplebackend

import org.apache.juli.logging.LogFactory
import simplebackend.Character

import grails.rest.RestfulController

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CharacterController extends RestfulController {

    static responseFormats = ['json']
    private static final log = LogFactory.getLog(this)

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Character.list(params), model:[characterInstanceCount: Character.count()]
    }

    def show(Character characterInstance) {
        respond characterInstance
    }

    def create() {
        respond new Character(params)
    }

    @Transactional
    def save(Character characterInstance) {
        if (characterInstance == null) {
            notFound()
            return
        }

        if (characterInstance.hasErrors()) {
            respond characterInstance.errors, view:'create'
            return
        }

        characterInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'character.label', default: 'Character'), characterInstance.id])
                redirect characterInstance
            }
            '*' { respond characterInstance, [status: CREATED] }
        }
    }

    def edit(Character characterInstance) {
        respond characterInstance
    }

    @Transactional
    def update(Character characterInstance) {
        if (characterInstance == null) {
            notFound()
            return
        }

        if (characterInstance.hasErrors()) {
            respond characterInstance.errors, view:'edit'
            return
        }

        characterInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Character.label', default: 'Character'), characterInstance.id])
                redirect characterInstance
            }
            '*'{ respond characterInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Character characterInstance) {

        if (characterInstance == null) {
            notFound()
            return
        }

        characterInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Character.label', default: 'Character'), characterInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'character.label', default: 'Character'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }


    def showCharacter() {

        log.debug "CharacterController - showCharacter()"

        //I know there is only one character with level 100
        def character = Character.findByLevel(100)

        def response = [
                id: character.id,
                gold: character.gold,
                level: character.level,
                name: character.name,
                class: character.type,
                race: character.race,
                armor: character.armors.collect { Armor a ->
                    [
                            ilevel: a.level,
                            name: a.name
                    ]
                }
        ]

        log.debug("CharacterController - showCharacter() - Response: " + response)
        respond response
    }
}
