package Stack



class StackImplementation<T: Any> : Stack<T> {

    private val storage = arrayListOf<T>()

    override val count: Int
        get() = storage.size


    override fun pop(): T? {
        return storage.removeLastOrNull()
    }

    override fun peek(): T? {
        return storage.lastOrNull()
    }

    override fun push(element: T) {
        storage.add(element)
    }
}

fun String.validParenthesis(): Boolean{
    val stack = StackImplementation<Char>()

    for (char in this){
        when(char){
            '(' -> {
                stack.push(char)
            }
            ')' -> {
                if (stack.isEmpty){
                    return false
                }else{
                    stack.pop()
                }
            }
        }
    }

    return stack.isEmpty
}