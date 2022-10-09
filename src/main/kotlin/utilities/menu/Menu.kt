package utilities.menu

import java.util.*

class Menu() : Runnable {
    private val menuItems: MutableMap<String, MenuItem> = HashMap()
    fun add(menuItem: MenuItem) {
        if (menuItems.containsKey(menuItem.command)) {
            throw RuntimeException("Menu Item already exists")
        }
        menuItems[menuItem.command] = menuItem
    }

    override fun run() {
        println("Choose your desired Action:")
        var quit = false
        while (!quit) {
            menuItems.values.reversed().forEach { item: MenuItem -> println(item.command + " -> " + item.description) }
            print(">")
            val input = readLine()
            if (menuItems[input] == null) {
                println("Incorrect Input")
            } else if (input == "q") {
                quit = true
            } else {
                menuItems[input]!!.performAction()
            }
        }
    }
}