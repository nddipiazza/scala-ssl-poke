package com.lucidworks

import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClients

object Test {

  def main(args: Array[String]): Unit = {
    val content = getRestContent(args(0))
    println(content);
  }

  /**
   * Returns the text content from a REST URL. Returns a blank String if there
   * is a problem.
   */
  def getRestContent(url:String): String = {
    val httpClient = HttpClients.createDefault();
    val httpResponse = httpClient.execute(new HttpGet(url))
    val entity = httpResponse.getEntity
    var content = ""
    if (entity != null) {
      val inputStream = entity.getContent
      content = io.Source.fromInputStream(inputStream).getLines.mkString
      inputStream.close()
    }
    httpClient.close()
    content
  }

}