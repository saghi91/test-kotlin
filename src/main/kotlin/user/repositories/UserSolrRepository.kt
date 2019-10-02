package user.repositories

import com.google.inject.Inject
import org.apache.solr.client.solrj.impl.HttpSolrClient
import user.User
import java.time.Instant
import java.util.*

class UserSolrRepository @Inject constructor(private val solrClient: HttpSolrClient) {
   fun create(): String {
       val testCore = User(UUID.randomUUID(), "saghi test name", "123456", 20, Instant.now())
       solrClient.addBean("testcore", testCore)
       solrClient.commit("testcore")

       return "created successfully!"
   }


//    override fun save(user: User): Response {
//        val queryParamMap = createQueryParam()
//        val queryParams = MapSolrParams(queryParamMap)
//        val response = solrClient.query("testcore", queryParams).results
//    }
//
//    private fun createQueryParam(): MutableMap<String, String> {
//        val queryParamMap: MutableMap<String, String> = mutableMapOf()
//        queryParamMap["q"] = "*:*"
//        queryParamMap["f1"] = "id, name"
//
//        return queryParamMap
//    }
//
//    override fun findAll(): List<String> {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
}



