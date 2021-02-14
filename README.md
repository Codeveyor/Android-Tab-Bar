#Android-Tab-Bar (iOS UITabBar in Android)
Android Bottom Navigation (mimicking iOS UITabBar) without a limitation to have more than one instance of  a fragment through it's navigation stacks. 

[!](tab_bar.png)


It started as a response to an original implementation of a [NavigationAdvancedSample](https://github.com/android/architecture-components-samples) from official Android repo. Its limitation is described in [Behavior](https://material.io/components/bottom-navigation/android#behavior) section of material.io guide, especially comparing to iOS Tab Bar - you cannot have more than one instance of one screen (Fragment) in the whole app flow. This may be frustrating as if you, for example, are creating an Android application identical to an existing iOS one which does not have such a limitation. So this project is solving this problem, giving you quite a flexible working solution. 

##What's included (iOS terms):
- tab bar
- navigation bars with a back button in every tab
- simple table views usage
- forward and back navigation animations


##IMPORTANT
For the sake of simplicity of the test project implementation some of issues are not adressed. For example, one of them - few fast clicks on the navigation button (forward move) may end with more than one instance of the fragment become created and put into navigation stack. Please handle them by yourself or according to the business logic of your application.