package com.example.testappmaxix.ui.navigation


interface Destination {
    val route: String
}

sealed class NavDestination {

    object Name : Destination {
        override val route: String
            get() = "Name "
    }

    object Age : Destination {
        override val route: String
            get() = "Age "
    }

    object Info : Destination {
        override val route: String
            get() = "Info "
    }
}