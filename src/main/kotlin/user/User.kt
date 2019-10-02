package user

import org.apache.solr.client.solrj.beans.Field
import java.time.Instant
import java.util.*

data class User(
    @Field val user_id: UUID = UUID.randomUUID(),
    @Field val name: String = "",
    @Field val password: String = "",
    @Field val age: Int = -1,
    @Field val creation_date: Instant = Instant.now())

