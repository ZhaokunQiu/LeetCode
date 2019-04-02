import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams g =new GroupAnagrams();
//        List<List<String>> temp = g.groupAnagrams(new String[]{"compilations","bewailed","horology","lactated","blindsided",
//                "swoop","foretasted","ware","abuts","stepchild","arriving","magnet","vacating","relegates","scale",
//                "melodically","proprietresses","parties","ambiguities","bootblacks","shipbuilders","umping","belittling",
//                "lefty","foremost","bifocals","moorish","temblors","edited","hint","serenest","rendezvousing","schoolmate",
//                "fertilizers","daiquiri","starr","federate","rectal","case","kielbasas","monogamous","inflectional","zapata",
//                "permitted","concessions","easters","communique","angelica","shepherdess","jaundiced","breaks","raspy",
//                "harpooned","innocence","craters","cajun","pueblos","housetop","traits","bluejacket","pete","snots",
//                "wagging","tangling","cheesecakes","constructing","balanchine","paralyzed","aftereffects","dotingly",
//                "definitions","renovations","surfboards","lifework","knacking","apprises","minimalism","skyrocketed",
//                "artworks","instrumentals","eardrums","hunching","codification","vainglory","clarendon","peters",
//                "weeknight","statistics","ay","aureomycin","lorrie","compassed","speccing","galen","concerto","rocky",
//                "derision","exonerate","sultrier","mastoids","repackage","cyclical","gowns","regionalism","supplementary",
//                "bierce","darby","memorize","songster","biplane","calibrates","decriminalizes","shack","idleness",
//                "confessions","snippy","barometer","earthing","sequence","hastiness","emitted","superintends","stockades",
//                "busywork","dvina","aggravated","furbelow","hashish","overextended","foreordain","lie","insurance",
//                "recollected","interpreted","congregate","ranks","juts","dampen","gaits","eroticism","neighborhoods",
//                "perihelion","simulations","fumigating","balkiest","semite","epicure","heavier","masterpiece","bettering",
//                "lizzie","wail","batsmen","unbolt","cudgeling","bungalow","behalves","refurnishes","pram","spoonerisms",
//                "cornered","rises","encroachments","gabon","cultivation","parsed","takeovers","stampeded","persia",
//                "devotional","doorbells","psalms","cains","copulated","archetypal","cursores","inbred","paradigmatic",
//                "thesauri","rose","stopcocks","weakness","ballsier","jagiellon","torches","hover","conservationists",
//                "brightening","dotted","rodgers","mandalay","overjoying","supervision","gonads","portage","crap",
//                "capers","posy","collateral","funny","garvey","ravenously","arias","kirghiz","elton","gambolled",
//                "highboy","kneecaps","southey","etymology","overeager","numbers","ebullience","unseemly","airbrushes",
//                "excruciating","gemstones","juiciest","muftis","shadowing","organically","plume","guppy","obscurely",
//                "clinker","confederacies","unhurried","monastic","witty","breastbones","ijsselmeer","dublin","linnaeus",
//                "dervish","bluefish","selectric","syllable","pogroms","pacesetters","anastasia","pandora","foci","bipartisan","loomed","emits","gracious","warfare","uncouples","augusts","portray","refinery","resonances","expediters","deputations","indubitably","richly","motivational","gringo","hubris","mislay","scad","lambastes","reemerged","wart","zirconium","linus","moussorgsky","swopped","sufferer","sputtered","tamed","merrimack","conglomerate","blaspheme","overcompensate","rheas","pares","ranted","prisoning","rumor","gabbles","lummox","lactated","unzipping","tirelessly","backdate","puzzling","interject","rejections","bust","centered","oxymoron","tangibles","sejong","not","tameness","consumings","prostrated","rowdyism","ardent","macabre","rustics","dodoes","warheads","wraths","bournemouth","staffers","retold","stiflings","petrifaction","larkspurs","crunching","clanks","briefest","clinches","attaching","extinguished","ryder","shiny","antiqued","gags","assessments","simulated","dialed","confesses","livelongs","dimensions","lodgings","cormorants","canaries","spineless","widening","chappaquiddick","blurry","lassa","vilyui","desertions","trinket","teamed","bidets","mods","lessors","impressiveness","subjugated","rumpuses","swamies","annotations","batiks","ratliff","waxwork","grander","junta","chutney","exalted","yawl","joke","vocational","diabetic","bullying","edit","losing","banns","doleful","precision","excreting","foals","smarten","soliciting","disturbance","soggily","gabrielle","margret","faded","pane","jerusalem","bedpan","overtaxed","brigs","honors","repackage","croissants","kirov","crummier","limeades","grandson","criers","bring","jaundicing","omnibusses","gawking","tonsillectomies","deodorizer","nosedove","commence","faulkner","adultery","shakedown","wigwag","wiper","compatible","ultra","adamant","distillation","gestates","semi","inmate","onlookers","grudgingly","recipe","chaise","dialectal","aphids","flimsier","orgasm","sobs","swellheaded","utilize","karenina","irreparably","preteen","mumble","gingersnaps","alumnus","chummiest","snobbish","crawlspaces","inappropriate","ought","continence","hydrogenate","eskimo","desolated","oceanic","evasive","sake","laziest","tramps","joyridden","acclimatized","riffraff","thanklessly","harmonizing","guinevere","demanded","capabler","syphilitics","brainteaser","creamers","upholds","stiflings","walt","luau","deafen","concretely","unhand","animations","map","limbos","tranquil","windbreakers","limoges","varying","declensions","signs","green","snowbelt","homosexual","hopping","residue","ransacked","emeritus","pathologist","brazenly","forbiddingly","alfredo","glummest","deciphered","delusive","repentant","complainants","beets","syntactics","vicissitude","incompetents","concur","canaan","rowdies","streamer","martinets","shapeliness","videodiscs","restfulness","rhea","consumed","pooching","disenfranchisement","impoverishes","behalf","unsuccessfully","complicity","ulcerating","derisive","jephthah","clearing","reputation","kansan","sledgehammer","benchmarks","escutcheon","portfolios","mandolins","marketable","megalomaniacs","kinking","bombarding","wimple","perishes","rukeyser","squatter","coddle","traditionalists","sifts","agglomerations","seasonings","brightness","spices","claimant","sofas","ambulatories","bothered","businessmen","orly","kinetic","contracted","grenadiers","flooding","dissolved","corroboration","mussed","squareness","alabamans","dandelions","labyrinthine","pot","waxwing","residential","pizza","overjoying","whelps","overlaying","elanor","tented","masterminded","balsamed","powerhouses","tramps","eisenstein","voile","repellents","beaus","coordinated","wreckers","eternities","untwists",
//                "estrangements","vitreous","embodied"});
        List<List<String>> temp = g.groupAnagrams(new String[]{"tameness","assessments"});
        for(List<String> aaa : temp)
        {
            if(aaa.size() > 1)
                System.out.println(aaa);
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        StringBuilder temp[] = new StringBuilder[strs.length];
        int i = 0;
        for(String input : strs){
            temp[i] =new StringBuilder( "00000000000000000000000000");
            char[] chars = input.toCharArray();
            for(char a : chars){
                temp[i].setCharAt(a-'a',Integer.toString(Character.getNumericValue(temp[i].charAt(a-'a'))+1).toCharArray()[0]);
            }
            i++;
        }
        HashMap<String,List<String>> result= new HashMap<>();
        for(int j = 0;j < strs.length; ++j){
            if(result.containsKey(temp[j].toString())){
                List<String> t = result.get(temp[j].toString());
                t.add(strs[j]);
            }
            else{
                List<String> t = new ArrayList<>();
                t.add(strs[j]);
                result.put(temp[j].toString(),t);
            }
        }
        List<List<String>> real = new LinkedList<>();
        Iterator map1it= result.entrySet().iterator();
        while(map1it.hasNext())
        {
            Map.Entry<String, List<String>> entry=(Map.Entry<String, List<String>>) map1it.next();
            ((LinkedList<List<String>>) real).addLast(entry.getValue());
        }
        return real;
    }


    public static List<List<String>> groupAnagrams2(String[] strs) {
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};//最多10609个z

        List<List<String>> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (String s : strs) {
            int key = 1;
            for (char c : s.toCharArray()) {
                key *= prime[c - 'a'];
            }
            List<String> t;
            if (map.containsKey(key)) {
                t = res.get(map.get(key));
            } else {
                t = new ArrayList<>();
                res.add(t);
                map.put(key, res.size() - 1);
            }
            t.add(s);
        }
        return res;
    }
}
