interface IIterator<T>
{
    fun next(): T
    fun hasNext(): Boolean
}

interface IIterableCollection<T>
{
    fun getIterator(): IIterator<T>
}

class DiagonalIterator(private val collection: IntMatrix): IIterator<Int>
{
    var currentRow = collection.hight - 1
    private set
    var currentColumn = 0
    private set
    override fun next(): Int
    {
        val value = collection[currentRow][currentColumn]
        if(currentRow + 1 == collection.hight)
            currentRow = 0
        else
        {
            ++currentRow
            ++currentColumn
        }
        return value
    }
    override fun hasNext() = currentColumn != collection.width
}

class IntMatrix(private val matrix: List<List<Int>>): IIterableCollection<Int>
{
    val width = matrix.first().size
    val hight = matrix.size
    override fun getIterator(): IIterator<Int> = DiagonalIterator(this)
    operator fun get(i: Int): List<Int> = matrix[i]
}

fun main()
{
    val matrix = IntMatrix(listOf(listOf(2, 4, 6),
                                  listOf(1, 3, 5)))

    val iterator = matrix.getIterator()
    while(iterator.hasNext())
        iterator.next()
}