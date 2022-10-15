package utilities.menu

import java.util.*


//menu consisting menu items different menus can be nested within each other
class Menu() : Runnable {
    private val menuItems = sortedMapOf<String, MenuItem>()
    fun add(menuItem: MenuItem) {
        if (menuItems.containsKey(menuItem.command)) {
            throw RuntimeException("Menu Item already exists")
        }
        menuItems[menuItem.command] = menuItem
    }

   //runs menu, shows possible options (MenuItems) and wait for valid user input and executes action
    override fun run() {
        println("Choose your desired Action:")
        var quit = false
        while (!quit) {
            menuItems.values.reversed().forEach { item: MenuItem -> println(item.command + " -> " + item.description) }
            print(">")
            val input = readLine()
            if (menuItems[input] == null) {
                println("Incorrect Input")
            } else if (input == "Q") {
                quit = true
            } else {
                menuItems[input]!!.performAction()
            }
        }
    }
}