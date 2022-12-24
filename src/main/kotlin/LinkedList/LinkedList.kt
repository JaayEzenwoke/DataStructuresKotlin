package LinkedList

class LinkedList<T: Any> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0

    fun isEmepty():Boolean = size == 0

    override fun toString():String{
        return if(isEmepty()){
            "Empty list"
        }else{
            head.toString()
        }
    }


    fun push(value: T){
        head = Node(value = value, next = head)

        if(tail == null){
            tail = head

        }

        size++
    }

    fun append(value :T){
        if(isEmepty()){
            push(value)
            return
        }
        val newNode = Node(value = value)
        tail!!.next = newNode
        tail = newNode
    }

    fun insert(value: T, afterNode :Node<T>):Node<T>{
        if (tail == afterNode){
            append(value)
            return tail!!
        }
        val newNode = Node(value = value, next = afterNode.next)
        afterNode.next == newNode
        size++
        return newNode
    }

    fun nodeAt(index:Int): Node<T>? {
        var currentNode = head
        var currentIndex = 0
        while (currentNode != null && currentIndex < index){
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }


    fun pop():T?{
        if (isEmepty()) return null
        val result = head?.value
        size--
        if(isEmepty()){
            tail = null
        }
        return result
    }


    fun removeLast():T?{
        val head = head ?: return null
        if (head.next == null) return pop()
        size--
        var prev = head
        var current = head
        var next = current.next
        while(next != null){
            prev = current
            current = next
            next = current.next
        }
        prev.next = null
        tail = prev
        return current.value
    }


    fun removeAfter(node: Node<T>):T?{
        var result = node.next?.value
        if(node.next == tail){
            tail = node
        }

        if(node.next != null){
            size--
        }

        node.next = node.next?.next
        return  result
    }
}