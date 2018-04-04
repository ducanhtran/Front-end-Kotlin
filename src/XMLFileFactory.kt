package com.example.Springtutorial

import java.io.File
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.stream.StreamResult
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import org.w3c.dom.Element

class XMLFileFactory {
    fun LuuFile(data:MutableList<SanPham>,path:String):Boolean
    {
        try{
            val docFactory =
                    DocumentBuilderFactory.newInstance()
            val docBuilder = docFactory.newDocumentBuilder()
            val doc = docBuilder.newDocument()
            val rootElement = doc.createElement("SanPhams")
            doc.appendChild(rootElement)
            for(sp in data)
            {
                val sanPhamElement =
                        doc.createElement("SanPham")
                val maElement=doc.createElement("Ma")
                maElement.textContent=sp.ma.toString()
                sanPhamElement.appendChild(maElement)
                val tenElement=doc.createElement("Ten")
                tenElement.textContent=sp.ten
                sanPhamElement.appendChild(tenElement)
                val giaElement=doc.createElement("Gia")
                giaElement.textContent=sp.donGia.toString()
                sanPhamElement.appendChild(giaElement)
                rootElement.appendChild(sanPhamElement);
            }
            val transformerFactory =
                    TransformerFactory.newInstance()
            val transformer =
                    transformerFactory.newTransformer()
            val source = DOMSource(doc)
            val result = StreamResult(File(path).absolutePath)

            transformer.transform(source, result)
            return true
        }
        catch (ex:Exception)
        {
            ex.printStackTrace()
        }
        return false
    }

    fun DocFile(path: String) :MutableList<SanPham>
    {
        var data:MutableList<SanPham> = mutableListOf()
        try {
            val factory = DocumentBuilderFactory.newInstance()
            val builder = factory.newDocumentBuilder()
            val xmlfile = File(path)
            val document = builder.parse(xmlfile)
            val nodeList = document.documentElement.childNodes
            for (i in 0..nodeList.length - 1) {
                val node = nodeList.item(i)
                if (node is Element) {
                    val sp = SanPham()
                    val childNodes = node.getChildNodes()
                    for (j in 0..childNodes.getLength() - 1) {
                        val cNode = childNodes.item(j)
                        if (cNode is Element) {
                            val content =
                                    cNode.getLastChild().getTextContent().trim()
                            when (cNode.getNodeName()) {
                                "Ma" -> sp.ma= content.toInt()
                                "Ten" -> sp.ten= content
                                "Gia" -> sp.donGia=
                                        content.toDouble()
                            }
                        }
                    }
                    data.add(sp)
                }
            }
        }
        catch (ex:Exception)
        {
            ex.printStackTrace()
        }
        return data
    }
}
