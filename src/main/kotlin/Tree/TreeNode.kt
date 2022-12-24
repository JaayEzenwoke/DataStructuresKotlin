package Tree

import Queue.QueueImplementation


//typealias that helps apply recursion when transversing the tree
typealias  Visitor<T> = (TreeNode<T>) -> Unit


class TreeNode<T>(val value: T) {


    //children of the tree
    private val children:MutableList<TreeNode<T>> = mutableListOf()


    //add a node to the child
    fun add(child: TreeNode<T>) = children.add(child)



    //tranversing via the depth
    fun forEachDepthFirst(visit : Visitor<T>){
        visit(this)

        children.forEach{
            it.forEachDepthFirst(visit)
        }
    }


    //for transversing level by level horizontally
    fun forEachleveOrder(visit:Visitor<T>){

        val queue = QueueImplementation<TreeNode<T>>()

        children.forEach{
            queue.enqueue(it)
        }
        var node = queue.dequeue()
        while (node != null){
            visit(node)

            node.children.forEach { queue.enqueue(it) }
            node = queue.dequeue()
        }
    }


    //search for an item
    fun search(value: T): TreeNode<T>? {
        var result:TreeNode<T>? = null

        forEachDepthFirst {
            if(it.value == value){
                result = it
            }
        }
        return result
    }


    //print each node in each leve
    fun printEachLevel(){
        val queue = QueueImplementation<TreeNode<T>>()

        var nodeLeftInCurrentLevel = 0
        queue.enqueue(this)
        while(!queue.isEmpty){
            nodeLeftInCurrentLevel = queue.count

            while(nodeLeftInCurrentLevel > 0){
                val node = queue.dequeue()

                if(node != null){
                    node.children.forEach { queue.enqueue(it) }
                    nodeLeftInCurrentLevel--
                }
                else{
                    break
                }
            }
        }
    }
}