# BindingExtension discovers the binding class at runtime by walking
# generic supertype signatures (findClass in Utils.kt) and then invoking
# the binding's static inflate(...) reflectively. R8 strips the Signature
# attribute and inflate methods by default, which crashes every
# BindingActivity/BindingFragment in minified builds (see issue #11).

-keepattributes Signature

-keep class com.jintin.bindingextension.** { *; }

# Keep subclasses (and their generic signatures) so the supertype walk
# still finds the parameterized BindingActivity/BindingFragment.
-keep class * extends com.jintin.bindingextension.BindingActivity
-keep class * extends com.jintin.bindingextension.BindingFragment

-keepclassmembers class * implements androidx.viewbinding.ViewBinding {
    public static ** inflate(...);
    public static ** bind(android.view.View);
}
