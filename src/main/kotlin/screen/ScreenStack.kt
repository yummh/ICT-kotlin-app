package screen

object ScreenStack {
    private val screenStack = mutableListOf<Screen>()

    fun push(screen: Screen){   // 상단에 새로운 스크린 추가
        screenStack.add(screen)
    }

    fun pop(){   // 스크린 제거
        screenStack.removeLastOrNull()
    }

    fun peek(): Screen? {   // 상단 스크린 조회
        return screenStack.lastOrNull()
    }

    // fun isEmpty - extension function을 통해 구현 필요 X
}

sealed class Screen