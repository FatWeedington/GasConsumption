package utilities.menu

class MenuItem(val command: String, val description: String, private val action: Runnable?) {
    fun performAction() {
        action?.run()
    }
}
