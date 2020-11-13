package xyz.yhsj.compose.utils

import androidx.compose.animation.Crossfade
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import xyz.yhsj.compose.defView

object Navigation : LifecycleObserver {
    private val stack = arrayListOf<@Composable () -> Unit>({ defView() })
    private var current: @Composable () -> Unit by mutableStateOf(stack[0])

    @Composable
    fun viewContent() {
        Surface {
            Crossfade(current = current) {
                current.invoke()
            }
        }
    }

    fun setRootPage(page: @Composable () -> Unit) {
        stack.clear()
        push(page)
    }


    fun pop(): Boolean {
        stack.remove(current)
        updateCurrentScreen()
        return true
    }


    fun push(page: @Composable () -> Unit): Boolean {
        stack.add(page)
        updateCurrentScreen()
        return true
    }

    private fun updateCurrentScreen() {
        current = stack.last()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        stack.clear()
    }

    fun onBackPressed(): Boolean {
        if (stack.size == 1) {
            return false
        }
        if (stack.size > 1) {
            pop()
            return true
        }
        return false
    }
}

