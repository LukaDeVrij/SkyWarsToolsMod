package org.polyfrost.example.client

import org.polyfrost.example.ExampleConstants
import org.polyfrost.oneconfig.api.config.v1.Config
import org.polyfrost.oneconfig.api.config.v1.annotations.Dropdown
import org.polyfrost.oneconfig.api.config.v1.annotations.Slider
import org.polyfrost.oneconfig.api.config.v1.annotations.Switch

object ExampleConfig : Config("${ExampleConstants.ID}.json", ExampleConstants.NAME, Category.OTHER) {

    @JvmStatic
    @Switch(title = "Example Switch")
    var exampleSwitch = false // The default value for the boolean Switch

    @JvmStatic
    @Slider(title = "Example Slider", min = 0f, max = 100f, step = 10f)
    var exampleSlider = 50f // The default value for the float Slider

    @Dropdown(title = "Example Dropdown", options = ["Option 1", "Option 2", "Option 3", "Option 4"])
    var exampleDropdown = 1 // Default option (in this case, "Option 2")

}
