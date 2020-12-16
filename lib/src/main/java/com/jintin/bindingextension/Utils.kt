@file:Suppress("UNCHECKED_CAST")

package com.jintin.bindingextension

import android.content.ComponentCallbacks
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

internal fun <V : ViewBinding> Class<*>.getBinding(layoutInflater: LayoutInflater): V {
    val clazz = (this
        .genericSuperclass as ParameterizedType)
        .actualTypeArguments[0] as Class<*>
    try {
        return clazz.getMethod(
            "inflate",
            LayoutInflater::class.java
        ).invoke(null, layoutInflater) as V
    } catch (ex: Exception) {
        throw RuntimeException("The ViewBinding inflate function has been changed.", ex)
    }
}

internal fun ComponentCallbacks.findClass(target: Class<*>): Class<*> {
    var javaClass: Class<*> = this.javaClass
    while (javaClass.superclass != target) {
        javaClass = javaClass.superclass
    }
    return javaClass
}

internal fun <V : ViewBinding> BindingActivity<V>.getBinding(): V {
    return findClass(BindingActivity::class.java).getBinding(layoutInflater)
}

internal fun <V : ViewBinding> BindingFragment<V>.getBinding(): V {
    return findClass(BindingFragment::class.java).getBinding(layoutInflater)
}