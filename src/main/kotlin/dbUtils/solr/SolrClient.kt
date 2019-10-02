package dbUtils.solr

import dbUtils.DataConnector
import org.apache.solr.client.solrj.impl.HttpSolrClient

class SolrClient: DataConnector<HttpSolrClient> {
    private val solrUrl = "http://localhost:8983/solr"

    override fun connect(): HttpSolrClient {
        return HttpSolrClient.Builder(solrUrl)
            .withConnectionTimeout(10000)
            .withSocketTimeout(60000)
            .build()
    }

}
