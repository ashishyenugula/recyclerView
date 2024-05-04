package com.ashish.myapplication.model

import com.google.gson.annotations.SerializedName

data class ResponseMain(
    @SerializedName("type_of"                  ) var typeOf                 : String?           = null,
    @SerializedName("id"                       ) var id                     : Int?              = null,
    @SerializedName("title"                    ) var title                  : String?           = null,
    @SerializedName("description"              ) var description            : String?           = null,
    @SerializedName("readable_publish_date"    ) var readablePublishDate    : String?           = null,
    @SerializedName("slug"                     ) var slug                   : String?           = null,
    @SerializedName("path"                     ) var path                   : String?           = null,
    @SerializedName("url"                      ) var url                    : String?           = null,
    @SerializedName("comments_count"           ) var commentsCount          : Int?              = null,
    @SerializedName("public_reactions_count"   ) var publicReactionsCount   : Int?              = null,
    @SerializedName("collection_id"            ) var collectionId           : Int?              = null,
    @SerializedName("published_timestamp"      ) var publishedTimestamp     : String?           = null,
    @SerializedName("positive_reactions_count" ) var positiveReactionsCount : Int?              = null,
    @SerializedName("cover_image"              ) var coverImage             : String?           = null,
    @SerializedName("social_image"             ) var socialImage            : String?           = null,
    @SerializedName("canonical_url"            ) var canonicalUrl           : String?           = null,
    @SerializedName("created_at"               ) var createdAt              : String?           = null,
    @SerializedName("edited_at"                ) var editedAt               : String?           = null,
    @SerializedName("crossposted_at"           ) var crosspostedAt          : String?           = null,
    @SerializedName("published_at"             ) var publishedAt            : String?           = null,
    @SerializedName("last_comment_at"          ) var lastCommentAt          : String?           = null,
    @SerializedName("reading_time_minutes"     ) var readingTimeMinutes     : Int?              = null,
    @SerializedName("tag_list"                 ) var tagList                : ArrayList<String> = arrayListOf(),
    @SerializedName("tags"                     ) var tags                   : String?           = null,
    @SerializedName("user"                     ) var user                   : User?             = User(),
    @SerializedName("organization"             ) var organization           : Organization?     = Organization(),
    @SerializedName("flare_tag"                ) var flareTag               : FlareTag?         = FlareTag()
)
