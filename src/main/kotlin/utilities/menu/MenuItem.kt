package utilities.menu

// class representing a menu item with displayed comand a description and action to run
class MenuItem(val command: String, val description: String, private val action: Runnable?) {

    //run action
    fun performAction() {
        action?.run()
    }
}
