enum class FileType
{
    DOC,
    XML,
    PNG,
    REMOTE
}

abstract class FilePreparer(val filePath: String)
{
    open fun prepare()
    {
        readFullFile()
        parsingFile()
        render()
    }

    open fun readFullFile()
    {
        // Just read full file
    }
    abstract fun parsingFile()
    abstract fun render()
}

class XMLFilePreparer(filePath: String): FilePreparer(filePath)
{
    override fun parsingFile()
    {
        // Special XML things
    }
    override fun render()
    {
        // Special XML thingss
    }
}

class RemoteFilePreparer(filePath: String): FilePreparer(filePath)
{
    override fun prepare()
    {
        download()
        readFullFile()
        parsingFile()
        render()
    }

    fun download()
    {
        // Download remote file
    }
    override fun readFullFile()
    {
        // Just read full file
    }
    override fun parsingFile()
    {
        // Special remote things
    }
    override fun render()
    {
        // Special remote things
    }
}

class FileViewer(var filePreparer: FilePreparer)
{
    fun showFile()
    {
        filePreparer.prepare()
    }
}

fun main()
{
    val xmlFilePreparer = XMLFilePreparer("file.xml")
    val fileViewer = FileViewer(xmlFilePreparer)

    fileViewer.showFile()
}