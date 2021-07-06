package com.lenatopoleva.redditpagingapp.model.data

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName


data class RedditResponse (
    @field:SerializedName("kind") val kind: String,
    @field:SerializedName("data") val data: Data
)

data class Data (
    val after: String?,
    val dist: Long,
    val modhash: String,

    @field:SerializedName("geo_filter")
    val geoFilter: Any? = null,

    @field:SerializedName("children") val children: List<Child>,
    val before: String? = null
)

data class Child (
    val kind: Kind,
    @field:SerializedName("data") val data: RedditPost
)

data class RedditPost (
    @field:SerializedName("approved_at_utc")
    val approvedAtUTC: Any? = null,

    val subreddit: Subreddit,
    val selftext: String,

    @field:SerializedName("author_fullname") val authorFullname: String,

    val saved: Boolean,

    @field:SerializedName("mod_reason_title")
    val modReasonTitle: Any? = null,

    val gilded: Long,
    val clicked: Boolean,
    val title: String,

    @field:SerializedName("link_flair_richtext")
    val linkFlairRichtext: List<Any?>,

    @field:SerializedName("subreddit_name_prefixed")
    val subredditNamePrefixed: SubredditNamePrefixed,

    val hidden: Boolean,
    val pwls: Long,

    @field:SerializedName("link_flair_css_class")
    val linkFlairCSSClass: LinkFlairCSSClass? = null,

    val downs: Long,

    @field:SerializedName("thumbnail_height")
    val thumbnailHeight: Long? = null,

    @field:SerializedName("top_awarded_type")
    val topAwardedType: String? = null,

    @field:SerializedName("hide_score")
    val hideScore: Boolean,

    val name: String,
    val quarantine: Boolean,

    @field:SerializedName("link_flair_text_color")
    val linkFlairTextColor: LinkFlairTextColor,

    @field:SerializedName("upvote_ratio")
    val upvoteRatio: Double,

    @field:SerializedName("author_flair_background_color")
    val authorFlairBackgroundColor: String? = null,

    @field:SerializedName("subreddit_type")
    val subredditType: SubredditType,

    val ups: Long,

    @field:SerializedName("total_awards_received")
    val totalAwardsReceived: Long,

    @field:SerializedName("media_embed")
    val mediaEmbed: MediaEmbed,

    @field:SerializedName("thumbnail_width")
    val thumbnailWidth: Long? = null,

    @field:SerializedName("author_flair_template_id")
    val authorFlairTemplateID: String? = null,

    @field:SerializedName("is_original_content")
    val isOriginalContent: Boolean,

    @field:SerializedName("user_reports")
    val userReports: List<Any?>,

    @field:SerializedName("secure_media")
    val secureMedia: Media? = null,

    @field:SerializedName("is_reddit_media_domain")
    val isRedditMediaDomain: Boolean,

    @field:SerializedName("is_meta")
    val isMeta: Boolean,

    val category: Any? = null,

    @field:SerializedName("secure_media_embed")
    val secureMediaEmbed: MediaEmbed,

    @field:SerializedName("link_flair_text")
    val linkFlairText: Any? = null,

    @field:SerializedName("can_mod_post")
    val canModPost: Boolean,

    val score: Long,

    @field:SerializedName("approved_by")
    val approvedBy: Any? = null,

    @field:SerializedName("is_created_from_ads_ui")
    val isCreatedFromAdsUI: Boolean,

    @field:SerializedName("author_premium")
    val authorPremium: Boolean,

    val thumbnail: String,
    val edited: Any,

    @field:SerializedName("author_flair_css_class")
    val authorFlairCSSClass: String? = null,

    @field:SerializedName("author_flair_richtext")
    val authorFlairRichtext: List<Any?>,

    val gildings: Gildings,

    @field:SerializedName("post_hint")
    val postHint: PostHint? = null,

    @field:SerializedName("content_categories")
    val contentCategories: Any? = null,

    @field:SerializedName("is_self")
    val isSelf: Boolean,

    @field:SerializedName("mod_note")
    val modNote: Any? = null,

    val created: Double,

    @field:SerializedName("link_flair_type")
    val linkFlairType: FlairType,

    val wls: Long,

    @field:SerializedName("removed_by_category")
    val removedByCategory: Any? = null,

    @field:SerializedName("banned_by")
    val bannedBy: Any? = null,

    @field:SerializedName("author_flair_type")
    val authorFlairType: FlairType,

    val domain: Domain,

    @field:SerializedName("allow_live_comments")
    val allowLiveComments: Boolean,

    @field:SerializedName("selftext_html")
    val selftextHTML: Any? = null,

    val likes: Any? = null,

    @field:SerializedName("suggested_sort")
    val suggestedSort: String? = null,

    @field:SerializedName("banned_at_utc")
    val bannedAtUTC: Any? = null,

    @field:SerializedName("url_overridden_by_dest")
    val urlOverriddenByDest: String,

    @field:SerializedName("view_count")
    val viewCount: Any? = null,

    val archived: Boolean,

    @field:SerializedName("no_follow")
    val noFollow: Boolean,

    @field:SerializedName("is_crosspostable")
    val isCrosspostable: Boolean,

    val pinned: Boolean,

    @field:SerializedName("over_18")
    val over18: Boolean,

    val preview: Preview? = null,

    @field:SerializedName("all_awardings")
    val allAwardings: List<AllAwarding>,

    val awarders: List<Any?>,

    @field:SerializedName("media_only")
    val mediaOnly: Boolean,

    @field:SerializedName("can_gild")
    val canGild: Boolean,

    val spoiler: Boolean,
    val locked: Boolean,

    @field:SerializedName("author_flair_text")
    val authorFlairText: String? = null,

    @field:SerializedName("treatment_tags")
    val treatmentTags: List<Any?>,

    val visited: Boolean,

    @field:SerializedName("removed_by")
    val removedBy: Any? = null,

    @field:SerializedName("num_reports")
    val numReports: Any? = null,

    val distinguished: Any? = null,

    @field:SerializedName("subreddit_id")
    val subredditID: SubredditID,

    @field:SerializedName("mod_reason_by")
    val modReasonBy: Any? = null,

    @field:SerializedName("removal_reason")
    val removalReason: Any? = null,

    @field:SerializedName("link_flair_background_color")
    val linkFlairBackgroundColor: String,

    val id: String,

    @field:SerializedName("is_robot_indexable")
    val isRobotIndexable: Boolean,

    @field:SerializedName("report_reasons")
    val reportReasons: Any? = null,

    val author: String,

    @field:SerializedName("discussion_type")
    val discussionType: Any? = null,

    @field:SerializedName("num_comments")
    val numComments: Long,

    @field:SerializedName("send_replies")
    val sendReplies: Boolean,

    @field:SerializedName("whitelist_status")
    val whitelistStatus: WhitelistStatus,

    @field:SerializedName("contest_mode")
    val contestMode: Boolean,

    @field:SerializedName("mod_reports")
    val modReports: List<Any?>,

    @field:SerializedName("author_patreon_flair")
    val authorPatreonFlair: Boolean,

    @field:SerializedName("author_flair_text_color")
    val authorFlairTextColor: String? = null,

    val permalink: String,

    @field:SerializedName("parent_whitelist_status")
    val parentWhitelistStatus: WhitelistStatus,

    val stickied: Boolean,
    val url: String,

    @field:SerializedName("subreddit_subscribers")
    val subredditSubscribers: Long,

    @field:SerializedName("created_utc")
    val createdUTC: Double,

    @field:SerializedName("num_crossposts")
    val numCrossposts: Long,

    val media: Media? = null,

    @field:SerializedName("is_video")
    val isVideo: Boolean
)

data class AllAwarding (
    @field:SerializedName("giver_coin_reward")
    val giverCoinReward: Long? = null,

    @field:SerializedName("subreddit_id")
    val subredditID: Any? = null,

    @field:SerializedName("is_new")
    val isNew: Boolean,

    @field:SerializedName("days_of_drip_extension")
    val daysOfDripExtension: Long,

    @field:SerializedName("coin_price")
    val coinPrice: Long,

    val id: String,

    @field:SerializedName("penny_donate")
    val pennyDonate: Long? = null,

    @field:SerializedName("award_sub_type")
    val awardSubType: AwardSubType,

    @field:SerializedName("coin_reward")
    val coinReward: Long,

    @field:SerializedName("icon_url")
    val iconURL: String,

    @field:SerializedName("days_of_premium")
    val daysOfPremium: Long,

    @field:SerializedName("tiers_by_required_awardings")
    val tiersByRequiredAwardings: Map<String, TiersByRequiredAwarding>? = null,

    @field:SerializedName("resized_icons")
    val resizedIcons: List<ResizedIcon>,

    @field:SerializedName("icon_width")
    val iconWidth: Long,

    @field:SerializedName("static_icon_width")
    val staticIconWidth: Long,

    @field:SerializedName("start_date")
    val startDate: Any? = null,

    @field:SerializedName("is_enabled")
    val isEnabled: Boolean,

    @field:SerializedName("awardings_required_to_grant_benefits")
    val awardingsRequiredToGrantBenefits: Long? = null,

    val description: String,

    @field:SerializedName("end_date")
    val endDate: Any? = null,

    @field:SerializedName("subreddit_coin_reward")
    val subredditCoinReward: Long,

    val count: Long,

    @field:SerializedName("static_icon_height")
    val staticIconHeight: Long,

    val name: String,

    @field:SerializedName("resized_static_icons")
    val resizedStaticIcons: List<ResizedIcon>,

    @field:SerializedName("icon_format")
    val iconFormat: Format? = null,

    @field:SerializedName("icon_height")
    val iconHeight: Long,

    @field:SerializedName("penny_price")
    val pennyPrice: Long? = null,

    @field:SerializedName("award_type")
    val awardType: AwardType,

    @field:SerializedName("static_icon_url")
    val staticIconURL: String
)

enum class AwardSubType(val value: String) {
    Appreciation("APPRECIATION"),
    Global("GLOBAL"),
    Group("GROUP"),
    Premium("PREMIUM");

    companion object {
        public fun fromValue(value: String): AwardSubType = when (value) {
            "APPRECIATION" -> Appreciation
            "GLOBAL"       -> Global
            "GROUP"        -> Group
            "PREMIUM"      -> Premium
            else           -> throw IllegalArgumentException()
        }
    }
}

enum class AwardType(val value: String) {
    Global("global");

    companion object {
        public fun fromValue(value: String): AwardType = when (value) {
            "global" -> Global
            else     -> throw IllegalArgumentException()
        }
    }
}

enum class Format(val value: String) {
    Apng("APNG"),
    PNG("PNG");

    companion object {
        public fun fromValue(value: String): Format = when (value) {
            "APNG" -> Apng
            "PNG"  -> PNG
            else   -> throw IllegalArgumentException()
        }
    }
}

data class ResizedIcon (
    val url: String,
    val width: Long,
    val height: Long,
    val format: Format? = null
)

data class TiersByRequiredAwarding (
    @field:SerializedName("resized_icons")
    val resizedIcons: List<ResizedIcon>,

    @field:SerializedName("awardings_required")
    val awardingsRequired: Long,

    @field:SerializedName("static_icon")
    val staticIcon: ResizedIcon,

    @field:SerializedName("resized_static_icons")
    val resizedStaticIcons: List<ResizedIcon>,

    val icon: ResizedIcon
)

enum class FlairType(val value: String) {
    Text("text");

    companion object {
        public fun fromValue(value: String): FlairType = when (value) {
            "text" -> Text
            else   -> throw IllegalArgumentException()
        }
    }
}

enum class Domain(val value: String) {
    DiscordGg("discord.gg"),
    IReddIt("i.redd.it"),
    RedditCOM("reddit.com"),
    VReddIt("v.redd.it");

    companion object {
        public fun fromValue(value: String): Domain = when (value) {
            "discord.gg" -> DiscordGg
            "i.redd.it"  -> IReddIt
            "reddit.com" -> RedditCOM
            "v.redd.it"  -> VReddIt
            else         -> throw IllegalArgumentException()
        }
    }
}

data class Gildings (
    @field:SerializedName("gid_1")
    val gid1: Long? = null,

    @field:SerializedName("gid_2")
    val gid2: Long? = null
)

enum class LinkFlairCSSClass(val value: String) {
    Lc("lc");

    companion object {
        public fun fromValue(value: String): LinkFlairCSSClass = when (value) {
            "lc" -> Lc
            else -> throw IllegalArgumentException()
        }
    }
}

enum class LinkFlairTextColor(val value: String) {
    Dark("dark");

    companion object {
        public fun fromValue(value: String): LinkFlairTextColor = when (value) {
            "dark" -> Dark
            else   -> throw IllegalArgumentException()
        }
    }
}

data class Media (
    @field:SerializedName("reddit_video")
    val redditVideo: RedditVideo
)

data class RedditVideo (
    @field:SerializedName("bitrate_kbps")
    val bitrateKbps: Long,

    @field:SerializedName("fallback_url")
    val fallbackURL: String,

    val height: Long,
    val width: Long,

    @field:SerializedName("scrubber_media_url")
    val scrubberMediaURL: String,

    @field:SerializedName("dash_url")
    val dashURL: String,

    val duration: Long,

    @field:SerializedName("hls_url")
    val hlsURL: String,

    @field:SerializedName("is_gif")
    val isGIF: Boolean,

    @field:SerializedName("transcoding_status")
    val transcodingStatus: TranscodingStatus
)

enum class TranscodingStatus(val value: String) {
    Completed("completed");

    companion object {
        public fun fromValue(value: String): TranscodingStatus = when (value) {
            "completed" -> Completed
            else        -> throw IllegalArgumentException()
        }
    }
}

typealias MediaEmbed = JsonObject

enum class WhitelistStatus(val value: String) {
    AllAds("all_ads");

    companion object {
        public fun fromValue(value: String): WhitelistStatus = when (value) {
            "all_ads" -> AllAds
            else      -> throw IllegalArgumentException()
        }
    }
}

enum class PostHint(val value: String) {
    HostedVideo("hosted:video"),
    Image("image"),
    Link("link");

    companion object {
        public fun fromValue(value: String): PostHint = when (value) {
            "hosted:video" -> HostedVideo
            "image"        -> Image
            "link"         -> Link
            else           -> throw IllegalArgumentException()
        }
    }
}

data class Preview (
    val images: List<Image>,
    val enabled: Boolean
)

data class Image (
    val source: ResizedIcon,
    val resolutions: List<ResizedIcon>,
    val variants: MediaEmbed,
    val id: String
)

enum class Subreddit(val value: String) {
    Aww("aww");

    companion object {
        public fun fromValue(value: String): Subreddit = when (value) {
            "aww" -> Aww
            else  -> throw IllegalArgumentException()
        }
    }
}

enum class SubredditID(val value: String) {
    T52Qh1O("t5_2qh1o");

    companion object {
        public fun fromValue(value: String): SubredditID = when (value) {
            "t5_2qh1o" -> T52Qh1O
            else       -> throw IllegalArgumentException()
        }
    }
}

enum class SubredditNamePrefixed(val value: String) {
    RAww("r/aww");

    companion object {
        public fun fromValue(value: String): SubredditNamePrefixed = when (value) {
            "r/aww" -> RAww
            else    -> throw IllegalArgumentException()
        }
    }
}

enum class SubredditType(val value: String) {
    Public("public");

    companion object {
        public fun fromValue(value: String): SubredditType = when (value) {
            "public" -> Public
            else     -> throw IllegalArgumentException()
        }
    }
}

enum class Kind(val value: String) {
    T3("t3");

    companion object {
        public fun fromValue(value: String): Kind = when (value) {
            "t3" -> T3
            else -> throw IllegalArgumentException()
        }
    }
}
