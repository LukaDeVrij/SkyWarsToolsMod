package org.polyfrost.example.config

import org.polyfrost.example.ExampleMod
import org.polyfrost.oneconfig.api.config.v1.Config
import org.polyfrost.oneconfig.api.config.v1.annotations.Dropdown
import org.polyfrost.oneconfig.api.config.v1.annotations.Slider
import org.polyfrost.oneconfig.api.config.v1.annotations.Switch

/**
 * The main Config entrypoint that extends the Config type and initializes your config options.
 * See [this link](https://docsv1.polyfrost.org/configuration/available-options) for more config options
 */
object ExampleConfig : Config("${ExampleMod.ID}.json", ExampleMod.NAME, Category.OTHER) {
    @Switch(title = "Example Switch")
    var exampleSwitch = false // The default value for the boolean Switch.

    @Slider(title = "Example Slider", min = 0F, max = 100F, step = 10F)
    var exampleSlider = 50f // The default value for the float Slider.

    @Dropdown(title = "Example Dropdown", options = ["Option 1", "Option 2", "Option 3", "Option 4"])
    var exampleDropdown = 1 // Default option (in this case "Option 2")
}