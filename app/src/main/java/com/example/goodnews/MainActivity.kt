package com.example.goodnews

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.beust.klaxon.Klaxon
import com.example.goodnews.Model.Articles
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.JsonHttpResponseHandler
import com.loopj.android.http.RequestParams
import cz.msebera.android.httpclient.Header
import org.json.JSONObject


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val reply : String = getNews()

        val testString : String = "{\"status\":\"ok\",\"totalResults\":5921,\"articles\":[{\"source\":{\"id\":\"bbc-news\",\"name\":\"BBC News\"},\"author\":\"https://www.facebook.com/bbcnews\",\"title\":\"New US guidance says fully vaccinated people can meet without masks\",\"description\":\"Guidelines from federal health officials say fully vaccinated people can meet indoors without masks.\",\"url\":\"https://www.bbc.co.uk/news/world-us-canada-56323907\",\"urlToImage\":\"https://ichef.bbci.co.uk/news/1024/branded_news/D3A3/production/_117497145_gettyimages-1231560950.jpg\",\"publishedAt\":\"2021-03-08T18:42:13Z\",\"content\":\"image copyrightGetty Images\\r\\nThe US Centers for Disease Control and Prevention (CDC) has announced that fully vaccinated Americans can return to some sense of normalcy.\\r\\nThose who have received the r… [+2419 chars]\"},{\"source\":{\"id\":\"bbc-news\",\"name\":\"BBC News\"},\"author\":\"https://www.facebook.com/bbcnews\",\"title\":\"Mark & Spencer launches online operations in 46 markets\",\"description\":\"The retailer's expansion into 46 markets marks the latest move to grow its digital business.\",\"url\":\"https://www.bbc.co.uk/news/business-56327257\",\"urlToImage\":\"https://ichef.bbci.co.uk/news/1024/branded_news/92E2/production/_115220673_gettyimages-1227704712.jpg\",\"publishedAt\":\"2021-03-08T18:15:07Z\",\"content\":\"Marks &amp; Spencer is to launch 46 new websites in overseas markets from Iceland to Uzbekistan, as part of moves to grow its online business.\\r\\nIt expands the retailer's online reach to more than 100… [+2098 chars]\"},{\"source\":{\"id\":\"bbc-news\",\"name\":\"BBC News\"},\"author\":\"https://www.facebook.com/bbcnews\",\"title\":\"Florence Price: Forgotten work by pioneering composer rediscovered\",\"description\":\"Florence Price was the first African-American woman to have a symphony performed by a top orchestra.\",\"url\":\"https://www.bbc.co.uk/news/entertainment-arts-56322440\",\"urlToImage\":\"https://ichef.bbci.co.uk/news/1024/branded_news/8BBC/production/_95027753_25ca6221-0a97-4956-8ecc-3e86f56c69ed.jpg\",\"publishedAt\":\"2021-03-08T18:13:20Z\",\"content\":\"By Mark SavageBBC music reporter\\r\\nimage captionFlorence Price's music has been brought to wider audiences in recent years\\r\\nA forgotten work by the pioneering composer Florence Price has been rediscov… [+5778 chars]\"},{\"source\":{\"id\":\"bbc-news\",\"name\":\"BBC News\"},\"author\":null,\"title\":\"Malala Yousafzai signs production deal with Apple TV+\",\"description\":\"The Nobel Prize laureate on why she is hopeful about change and representation on screen.\",\"url\":\"https://www.bbc.co.uk/news/av/world-56316463\",\"urlToImage\":\"https://ichef.bbci.co.uk/images/ic/400xn/p09921yq.jpg\",\"publishedAt\":\"2021-03-08T18:09:44Z\",\"content\":\"Activist Malala Yousafzai has signed a multi-year deal with Apple TV+, to produce programming including documentaries, dramas, comedies and films. \\r\\nThe Nobel Prize laureate said she wanted to inspir… [+67 chars]\"},{\"source\":{\"id\":\"bbc-news\",\"name\":\"BBC News\"},\"author\":\"https://www.facebook.com/bbcnews\",\"title\":\"Probe over Aberdeen prisoner who killed day after his release\",\"description\":\"Stuart Quinn stabbed dad-of-one Alan Geddes to death in Aberdeen the day after being freed from prison.\",\"url\":\"https://www.bbc.co.uk/news/uk-scotland-north-east-orkney-shetland-56300014\",\"urlToImage\":\"https://ichef.bbci.co.uk/news/1024/branded_news/6297/production/_117393252_geddespic.jpg\",\"publishedAt\":\"2021-03-08T18:06:53Z\",\"content\":\"By Connor GilliesBBC Scotland news\\r\\nimage copyrightGeddes family\\r\\nimage captionMurder victim Alan Geddes had a son\\r\\nThe circumstances of the release of a prisoner who murdered a man a day later are b… [+3971 chars]\"},{\"source\":{\"id\":\"bbc-news\",\"name\":\"BBC News\"},\"author\":null,\"title\":\"New 36-team Champions League format could be agreed this month\",\"description\":\"Plans for a reformed 36-team Champions League which would start in 2024 could be agreed by the end of this month.\",\"url\":\"https://www.bbc.co.uk/sport/football/56325695\",\"urlToImage\":\"https://ichef.bbci.co.uk/live-experience/cps/624/cpsprodpb/EAAF/production/_117497006_bayern_cl_getty_index.jpg\",\"publishedAt\":\"2021-03-08T18:06:14Z\",\"content\":\"Bayern Munich are the holders of the Champions League trophy after they beat PSG 1-0 in Lisbon in August to claim the crown for the sixth time\\r\\nPlans for a reformed 36-team Champions League which wou… [+3025 chars]\"},{\"source\":{\"id\":\"bbc-news\",\"name\":\"BBC News\"},\"author\":\"https://www.facebook.com/bbcnews\",\"title\":\"Emma Hardy MP quits shadow minster role over Covid workload\",\"description\":\"The Hull West and Hessle Labour MP says the number of people needing help has \\\"risen dramatically\\\".\",\"url\":\"https://www.bbc.co.uk/news/uk-england-humber-56326939\",\"urlToImage\":\"https://ichef.bbci.co.uk/news/1024/branded_news/B6F0/production/_108623864__108029148_emmahardy.jpg\",\"publishedAt\":\"2021-03-08T18:06:01Z\",\"content\":\"image captionEmma Hardy was elected as the Labour MP for Hull West and Hessle in 2017\\r\\nA Labour MP has resigned her shadow ministerial post citing an increase in her constituency work during lockdown… [+1151 chars]\"},{\"source\":{\"id\":\"bbc-news\",\"name\":\"BBC News\"},\"author\":null,\"title\":\"2021/03/08 18:00 GMT\",\"description\":\"The latest five minute news bulletin from BBC World Service.\",\"url\":\"https://www.bbc.co.uk/programmes/w172x5pc0dll9kc\",\"urlToImage\":\"https://ichef.bbci.co.uk/images/ic/1200x675/p060dh18.jpg\",\"publishedAt\":\"2021-03-08T18:06:00Z\",\"content\":\"The latest five minute news bulletin from BBC World Service.\"},{\"source\":{\"id\":\"bbc-news\",\"name\":\"BBC News\"},\"author\":\"https://www.facebook.com/bbcnews\",\"title\":\"Samuel Paty: French schoolgirl admits lying about murdered teacher\",\"description\":\"The student admits she was not in class when Samuel Paty showed cartoons of the Prophet Muhammad.\",\"url\":\"https://www.bbc.co.uk/news/world-europe-56325254\",\"urlToImage\":\"https://ichef.bbci.co.uk/news/1024/branded_news/F45F/production/_117495526_gettyimages-1280919040.jpg\",\"publishedAt\":\"2021-03-08T18:02:41Z\",\"content\":\"image copyrightGetty Images\\r\\nimage captionSamuel Paty's death sparked protests in France\\r\\nA French schoolgirl has admitted to lying and spreading false claims about a teacher who was murdered last ye… [+1710 chars]\"},{\"source\":{\"id\":\"bbc-news\",\"name\":\"BBC News\"},\"author\":\"https://www.facebook.com/bbcnews\",\"title\":\"Google HR 'suggested medical leave' for racism victims\",\"description\":\"Google staff in the US who complain over racism were advised to take mental health leave, NBC reports.\",\"url\":\"https://www.bbc.co.uk/news/technology-56321568\",\"urlToImage\":\"https://ichef.bbci.co.uk/news/1024/branded_news/28B3/production/_117491401_gettyimages-1230865877.jpg\",\"publishedAt\":\"2021-03-08T18:01:15Z\",\"content\":\"image copyrightGetty Images\\r\\nGoogle advised employees in the US who complained about racism and sexism to take medical leave and undergo mental health counselling, NBC News says.\\r\\nOne current employe… [+3351 chars]\"},{\"source\":{\"id\":\"bbc-news\",\"name\":\"BBC News\"},\"author\":\"https://www.facebook.com/bbcnews\",\"title\":\"Tottenham stabbings: One dead and two injured near White Hart Lane station\",\"description\":\"Three men have been attacked on Penshurst Road in Tottenham near White Hart Lane train station.\",\"url\":\"https://www.bbc.co.uk/news/uk-england-london-56326189\",\"urlToImage\":\"https://ichef.bbci.co.uk/news/1024/branded_news/18145/production/_117492689_capture.jpg\",\"publishedAt\":\"2021-03-08T17:59:41Z\",\"content\":\"image captionThree men were attacked on Penshurst Road near White Hart Lane train station\\r\\nA 19-year-old man has died and another teenager is in hospital after a stabbing in Tottenham, north London.\\r… [+826 chars]\"},{\"source\":{\"id\":\"bbc-news\",\"name\":\"BBC News\"},\"author\":null,\"title\":\"Covid: Boris Johnson thanks teachers for 'astonishing' work and praises home-schoolers\",\"description\":\"The prime minister thanks teachers for their work over the pandemic and praises home-schooling parents.\",\"url\":\"https://www.bbc.co.uk/news/av/uk-56327327\",\"urlToImage\":\"https://ichef.bbci.co.uk/images/ic/400xn/p099278n.jpg\",\"publishedAt\":\"2021-03-08T17:38:07Z\",\"content\":\"The prime minister has thanked teachers and home-schooling parents for their \\\"astonishing work\\\" over the coronavirus pandemic.\\r\\nDuring the Downing Street press briefing, Boris Johnson said it the gov… [+215 chars]\"},{\"source\":{\"id\":\"bbc-news\",\"name\":\"BBC News\"},\"author\":null,\"title\":\"Boris Johnson: 'Inevitable' Covid transmission risk with schools return\",\"description\":\"The PM said the rise of Covid-19 cases was inevitable he added that the vaccine roll out means its safe.\",\"url\":\"https://www.bbc.co.uk/news/av/uk-56326617\",\"urlToImage\":\"https://ichef.bbci.co.uk/images/ic/400xn/p09926vt.jpg\",\"publishedAt\":\"2021-03-08T17:36:57Z\",\"content\":\"Prime Minister Boris Johnson says it's \\\"inevitable\\\" that there will be a risk of increased Covid transmission with millions of children returning to school in England. \\r\\nHe explained that reopening s… [+267 chars]\"},{\"source\":{\"id\":\"bbc-news\",\"name\":\"BBC News\"},\"author\":\"https://www.facebook.com/bbcnews\",\"title\":\"Covid-19: PM thanks teachers, a third wave warning and triplets on their 'big day'\",\"description\":\"Five things you need to know about the coronavirus pandemic this Monday evening.\",\"url\":\"https://www.bbc.co.uk/news/uk-56325166\",\"urlToImage\":\"https://ichef.bbci.co.uk/news/1024/branded_news/CC94/production/_111527325_index_daily_update_version02_cv_976new.png\",\"publishedAt\":\"2021-03-08T17:32:39Z\",\"content\":\"Here are five things you need to know about the coronavirus pandemic this Monday evening. We'll have another update for you tomorrow morning. \\r\\nAfter millions of pupils returned to schools across Eng… [+3983 chars]\"},{\"source\":{\"id\":\"bbc-news\",\"name\":\"BBC News\"},\"author\":\"https://www.facebook.com/bbcnews\",\"title\":\"Man to stand trial on Celtic Park sex abuse charges\",\"description\":\"Frank Cairney denies accusations that he indecently assaulted three teenage boys at various locations.\",\"url\":\"https://www.bbc.co.uk/news/uk-scotland-glasgow-west-56298419\",\"urlToImage\":\"https://ichef.bbci.co.uk/news/1024/branded_news/16D33/production/_104819439_cairney.jpg\",\"publishedAt\":\"2021-03-08T17:30:38Z\",\"content\":\"image copyrightPress Team\\r\\nimage captionFrank Cairney denies charges of assault on three teenage boys\\r\\nA man is to stand trial accused of indecently assaulting a teenage boy at Celtic Park in Glasgow… [+1578 chars]\"},{\"source\":{\"id\":\"bbc-news\",\"name\":\"BBC News\"},\"author\":\"https://www.facebook.com/bbcnews\",\"title\":\"Asylum seekers: Napier Barracks and Penally camp 'filthy and run-down'\",\"description\":\"Inspectors criticised conditions at Napier Barracks in Folkestone and Penally camp in Pembrokeshire.\",\"url\":\"https://www.bbc.co.uk/news/uk-england-kent-56325360\",\"urlToImage\":\"https://ichef.bbci.co.uk/news/1024/branded_news/FC2F/production/_117495546_napier_barracks._17_february_2021.jpg\",\"publishedAt\":\"2021-03-08T17:30:20Z\",\"content\":\"image captionInspectors raised concerns over cleanliness at both camps, and said some areas were filthy\\r\\nMigrants were housed in cramped and filthy conditions at a military barracks, inspectors have … [+3116 chars]\"},{\"source\":{\"id\":\"bbc-news\",\"name\":\"BBC News\"},\"author\":null,\"title\":\"PSG v Istanbul Basaksehir: Official suspended until end of season for 'inappropriate behaviour'\",\"description\":\"Fourth official Sebastian Coltescu is suspended until the end of the season for \\\"inappropriate behaviour\\\" during the game between Paris St-Germain and Istanbul Basaksehir.\",\"url\":\"https://www.bbc.co.uk/sport/football/56324875\",\"urlToImage\":\"https://ichef.bbci.co.uk/live-experience/cps/624/cpsprodpb/E63B/production/_117493985_gettyimages-1290168129.jpg\",\"publishedAt\":\"2021-03-08T17:16:32Z\",\"content\":\"Pierre Webo (right) was sent off after a row with the fourth official\\r\\nRomanian fourth official Sebastian Coltescu has been suspended until the end of the season for \\\"inappropriate behaviour\\\" during … [+1097 chars]\"},{\"source\":{\"id\":\"bbc-news\",\"name\":\"BBC News\"},\"author\":\"https://www.facebook.com/bbcnews\",\"title\":\"Sarah Everard: Police speak to 'over 750 people' as search continues\",\"description\":\"More than 100 calls are made to the Met Police as the search for Sarah Everard enters its fifth day.\",\"url\":\"https://www.bbc.co.uk/news/uk-england-london-56326187\",\"urlToImage\":\"https://ichef.bbci.co.uk/news/1024/branded_news/EAFE/production/_117485106_mediaitem117485105.jpg\",\"publishedAt\":\"2021-03-08T17:10:54Z\",\"content\":\"image copyrightMet Police\\r\\nimage captionThe last confirmed sighting of Ms Everard was 30 minutes after she left her friend's home in Clapham on 3 March\\r\\nDetectives searching for a missing woman last … [+1578 chars]\"},{\"source\":{\"id\":\"bbc-news\",\"name\":\"BBC News\"},\"author\":null,\"title\":\"How Susie Wolff is inspiring the next generation of girls in motorsport\",\"description\":\"Venturi Racing team principal Susie Wolff explains how \\\"Girls on Track\\\" is inspiring the next generation of females in motorsport.\",\"url\":\"https://www.bbc.co.uk/sport/av/motorsport/56326326\",\"urlToImage\":\"https://ichef.bbci.co.uk/live-experience/cps/624/cpsprodpb/3D8F/production/_117495751_p0991tcm.jpg\",\"publishedAt\":\"2021-03-08T17:07:55Z\",\"content\":null},{\"source\":{\"id\":\"bbc-news\",\"name\":\"BBC News\"},\"author\":null,\"title\":\"2021/03/08 17:00 GMT\",\"description\":\"The latest five minute news bulletin from BBC World Service.\",\"url\":\"https://www.bbc.co.uk/programmes/w172x5pc0dll5t7\",\"urlToImage\":\"https://ichef.bbci.co.uk/images/ic/1200x675/p060dh18.jpg\",\"publishedAt\":\"2021-03-08T17:06:00Z\",\"content\":\"The latest five minute news bulletin from BBC World Service.\"}]}"

        val ArticlesReturned = Klaxon().parse<Articles>(testString)

    }

    private fun getNews() : String{
        val url = "https://newsapi.org/v2/everything?domains=bbc.co.uk&apiKey=60c79275a2964eb38fff01f189d27ee7"
        val client = AsyncHttpClient()
        val params = RequestParams()
        var reply : String = "failed"
        client[url, params, object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Array<Header>, response: JSONObject?) {
                // Root JSON in response is an dictionary i.e { "data : [ ... ] }
                // Handle resulting parsed JSON response here

                Log.e("jsonData",response.toString())
                reply = response.toString()
            }

            override fun onFailure(statusCode: Int, headers: Array<Header>, res: String, t: Throwable) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)

                Toast.makeText(applicationContext, "fail $statusCode", Toast.LENGTH_SHORT).show()
            }
        }]
        return reply
    }
}