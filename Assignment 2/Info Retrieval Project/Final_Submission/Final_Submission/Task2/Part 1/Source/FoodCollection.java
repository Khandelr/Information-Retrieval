

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class FoodCollection {

	public static void main(String[] args) throws Exception {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("test");
		DBCollection businessColl = db
				.getCollection("Food");
		HashSet<String> food=new HashSet<String>();
		/*
		 * foods list words
		 */
		
		food.add("paneer tikka masala");
		food.add("panner burji");
		food.add("pav bhaji");
		food.add("roti");
		food.add("dal");
		food.add("channa masala");
		food.add("mutter paneer");
		food.add("chicken tikka masala");
		food.add("chicken tandoori");
		// some more elements
		food.add("lunch");
		food.add("breakfast");
		food.add("breakfasts");
		food.add("dinner");
		food.add("entree");
		food.add("selection");
		food.add("food");
		food.add("desserts");
		food.add("fried chicken eggs");
		food.add("Chinese noodles");
		food.add("Chow mein");
		food.add("Noodle soup");
		food.add("Zhajiangmian");
		food.add("Lamian");
		food.add("White Rice");
		food.add("Fried Rice");
		food.add("Dongpo pork");
		food.add("sweet and meetha");
		food.add("Twice cooked pork");
		food.add("Char siu");
		food.add("Century egg");
		food.add("Duck's head");
		food.add("Kung Pao chicken");
		food.add("Peking Duck");
		food.add("Beijing");
		food.add("Soy egg");
		food.add("Tea egg");
		food.add("Buddha's delight");
		food.add("Pickled vegetables");
		food.add("Double steaming");
		food.add("Red cooking");
		food.add("Stir frying");
		food.add("Baozi");
		food.add("Dim sum");
		food.add("Cantonese cuisine");
		food.add("Guotie");
		food.add("Jiaozi");
		food.add("Mantou");
		food.add("Wonton");
		food.add("Xiaolongbao");
		food.add("Shanghai cuisine");
		food.add("Zongzi");
		food.add("Longevity buns");
		food.add("Cong you bing");
		food.add("Mooncake");
		food.add("Mid-Autumn Festival");
		food.add("Sachima");
		food.add("Shaobing");
		food.add("Youtiao");
		food.add("Congee");
		food.add("Hot and sour soup");
		food.add("Hot pot");
		food.add("Tong sui");
		food.add("Cantonese cuisine");
		food.add("Peking Duck");
		food.add("Zhajiangmian");
		food.add("Braised abalone");
		food.add("Shaved ice");
		food.add("Beef chow fun");
		food.add("Bird's nest soup");
		food.add("Black sesame soup");
		food.add("Cantonese seafood soup");
		food.add("Char siu");
		food.add("Crispy fried chicken");
		food.add("taro");
		food.add("Guilinggao");
		food.add("Little pan rice");
		food.add("Red bean soup");
		food.add("squab");
		food.add("suckling pig");
		food.add("Sea cucumber");
		food.add("Seafood with bird's nest");
		food.add("Shark fin soup");
		food.add("Snow fungus");
		food.add("Sour spare ribs");
		food.add("Spare ribs");
		food.add("watercress");
		food.add("apricot kernels");
		food.add("White cut chicken");
		food.add("Winter melon");
		food.add("Wonton noodles");
		food.add("Yeung Chow fried rice");
		food.add("Youtiao");
		food.add("Zhaliang");
		food.add("Yusheng");
		food.add("Popiah");
		food.add("Buddha jumps over the wall");
		food.add("Fried rice");
		food.add("Oyster omelette");
		food.add("Popiah");
		food.add("Yanpi");
		food.add("Hainanese chicken rice");
		food.add("Wenchang chicken");
		food.add("Chongqing spicy deep-fried chicken");
		food.add("Dandan noodles");
		food.add("Fuqi Feipian");
		food.add("Sichuan hotpot");
		food.add("Kung Pao chicken");
		food.add("Mapo tofu");
		food.add("Shuizhu");
		food.add("Twice cooked pork");
		food.add("Zhangcha duck");
		food.add("Over Bridge Rice Noodles");
		food.add("Beggar's Chicken");
		food.add("Aloo baingan masala");
		food.add("Aloo baingan");
		food.add("Gobhi Aloo");
		food.add("Aloo ki Tikki");
		food.add("Aloo Matar");
		food.add("Aloo methi");
		food.add("Aloo shimla mirch");
		food.add("Amriti with Rabdi");
		food.add("Amritsari fish");
		food.add("Kulcha");
		food.add("Arbi masala");
		food.add("Baati");
		food.add("Ghee");
		food.add("Clarified butter");
		food.add("Baigan bharta");
		food.add("Eggplant");
		food.add("Bharwaan baigan");
		food.add("Bharwaan tinde");
		food.add("Bharwein karela");
		food.add("Bhatura");
		food.add("Bhindi Masala");
		food.add("Biryani");
		food.add("Butter Chicken");
		food.add("Chaat");
		food.add("Chana masala");
		food.add("Chapathi");
		food.add("Chicken Razala");
		food.add("Chole bhature");
		food.add("Chick peas");
		food.add("Daal Baati");
		food.add("Churma");
		food.add("Daal Puri");
		food.add("Dal makhani");
		food.add("Dal");
		food.add("Dal tadka");
		food.add("Dum Aloo");
		food.add("Poha");
		food.add("French bean aloo");
		food.add("Gajar ka Halwa");
		food.add("Punjab");
		food.add("Ghee");
		food.add("Gajar matar aloo");
		food.add("Gobhi matar");
		food.add("Hari Mutter ka Nimona");
		food.add("Jeera aloo");
		food.add("Kachori");
		food.add("Kadai");
		food.add("Karela Bharta");
		food.add("Katha meetha petha/halwakadoo");
		food.add("Kheer");
		food.add("Khichdi");
		food.add("Kofta");
		food.add("Gram flour");
		food.add("Kulfi");
		food.add("Lauki ke kofte");
		food.add("Bottle gourd");
		food.add("Lauki ki subji");
		food.add("Bottle Gourd");
		food.add("Makki di roti");
		food.add("Sarson Da Saag");
		food.add("Mathura ke pede");
		food.add("Methi");
		food.add("Misi roti");
		food.add("Mixed vegetable");
		food.add("Moong dal ka halwa");
		food.add("Mushroom do pyaza");
		food.add("Mushroom matar");
		food.add("Naan");
		food.add("Navrattan korma");
		food.add("Palak Daal");
		food.add("Palak Paneer");
		food.add("Paneer");
		food.add("Paneer butter masala");
		food.add("Paneer Tikka Masala");
		food.add("Pani Puri");
		food.add("Panjeeri");
		food.add("Paratha");
		food.add("paneer");
		food.add("Pattor");
		food.add("Phirni");
		food.add("Pindi chana");
		food.add("Pinni");
		food.add("Rajma Chaval");
		food.add("Rajma");
		food.add("Kidney beans");
		food.add("Ramatori subji");
		food.add("Rice");
		food.add("Rongi");
		food.add("Samosa");
		food.add("Samose");
		food.add("Sattu ki Roti");
		food.add("Shahi paneer");
		food.add("Shahi tukra");
		food.add("Singhada Halwa");
		food.add("Sooji");
		food.add("Halwa");
		food.add("Semolina");
		food.add("Semolina");
		food.add("Sweet Pethas/ kesar petha/ pista petha");
		food.add("Jalfrezi");
		food.add("Appam");
		food.add("Avial");
		food.add("Bajji");
		food.add("fritters");
		food.add("Biryani");
		food.add("mutton");
		food.add("prawns");
		food.add("Bisi Bele Bath");
		food.add("Bonda");
		food.add("gram flour");
		food.add("Chicken 65");
		food.add("deep fried");
		food.add("Currivepillai sadam");
		food.add("Dosa");
		food.add("Double ka meetha");
		food.add("Goli bajje");
		food.add("Idiappam");
		food.add("Idli");
		food.add("rice");
		food.add("pulse");
		food.add("Indian omelette");
		food.add("Kaara Kozhambu");
		food.add("Keerai kootu");
		food.add("Keerai masiyal");
		food.add("Keerai sadam");
		food.add("Koottu");
		food.add("Kos kootu");
		food.add("Kothamali sadam");
		food.add("Kuzhakkattai");
		food.add("Kuzhambu");
		food.add("Masala Dosa");
		food.add("Parotta");
		food.add("Paruppu sadam");
		food.add("Payasam");
		food.add("Pongal");
		food.add("Poriyal");
		food.add("Puli sadam");
		food.add("Tamarind");
		food.add("Puttu");
		food.add("Kanji");
		food.add("porridge");
		food.add("Sakkara pongal");
		food.add("Sambar");
		food.add("Sevai");
		food.add("Sevai");
		food.add("Thayir sadam, Mosaranna");
		food.add("Thengai sadam");
		food.add("Uttapam");
		food.add("Vada");
		food.add("Varuval");
		food.add("Yelumincham sadam, Chitranna");
		food.add("poriyal");
		food.add("Upma");
		food.add("Rava");
		food.add("Koshambri");
		food.add("Obbattu");
		food.add("Pooran-poli");
		food.add("paratha");
		food.add("India");
		food.add("Ennai Kathirikkai");
		food.add("Ragi Mudhe");
		food.add("Pesarattu");
		food.add("Amti");
		food.add("Bajri no rotlo");
		food.add("Barfi");
		food.add("Basundi");
		food.add("Bhakri");
		food.add("Bombil fry");
		food.add("Chaat");
		food.add("Chakli");
		food.add("Chivda");
		food.add("Cholafali");
		food.add("Chorafali");
		food.add("Copra paak");
		food.add("Daal Dhokli");
		food.add("Dahi vada");
		food.add("Dhokla");
		food.add("Doodhpak");
		food.add("Dudhi no Halwo - Bottle Gourd Halwa");
		food.add("Dum aaloo");
		food.add("Pohe");
		food.add("Gajar Halwo - Carrot Halwa");
		food.add("Gatta curry");
		food.add("Ghari");
		food.add("Ghooghra");
		food.add("Gud papdi");
		food.add("Gol papdi");
		food.add("Gulab Jamun");
		food.add("Halvasan");
		food.add("Handwo (steamed dish)");
		food.add("Gur");
		food.add("Jalebi");
		food.add("Juvar no rotlo");
		food.add("Kansar");
		food.add("Keri no ras");
		food.add("Khakhra");
		food.add("Khandvi");
		food.add("Kombdi vade");
		food.add("Koshimbir");
		food.add("Laapsi");
		food.add("Laddu");
		food.add("Locha");
		food.add("Malpua");
		food.add("Methi na Gota");
		food.add("Modak");
		food.add("Muthiya");
		food.add("Panipuri");
		food.add("Patra");
		food.add("Pav Bhaji");
		food.add("Penda");
		food.add("Pooran-poli");
		food.add("Puri");
		food.add("Puri Bhaji");
		food.add("Rasya Muthia");
		food.add("Sabudana Khichadi");
		food.add("Sev Khamani");
		food.add("Sev Tameta");
		food.add("Shakarpara");
		food.add("Shankarpali");
		food.add("Shiro");
		food.add("Shrikhand");
		food.add("Sohan papdi");
		food.add("Soonvali");
		food.add("Sukhdi");
		food.add("Sutarfeni");
		food.add("Thalipeeth");
		food.add("Undhiyu");
		food.add("Upmaa");
		food.add("Vada pav");
		food.add("Veg Kolhapuri");
		food.add("Vindaloo");
		food.add("Ghevar");
		food.add("Kachori");
		food.add("Magaj");
		food.add("Ceera Doi");
		food.add("Dhup Pitha");
		food.add("Gheela Pitha");
		food.add("Hurum");
		food.add("Khar");
		food.add("Kumol Sawul");
		food.add("Loskora (Coconut Laddu)");
		food.add("Lusi");
		food.add("Malpua");
		food.add("Momo");
		food.add("Muri Laru");
		food.add("Pani Tenga");
		food.add("Sunga Pitha");
		food.add("Alu Pitika");
		food.add("Masor tenga");
		food.add("Bengena Pitika");
		food.add("Bilahi Maas");
		food.add("Black rice");
		food.add("Bora Sawul");
		food.add("Brown Rice");
		food.add("Chhenagaja");
		food.add("Chhenapoda");
		food.add("Chingri Machher Malai");
		food.add("Dal");
		food.add("Goja");
		food.add("Hando Guri");
		food.add("Haq Maas");
		food.add("Horioh Maas");
		food.add("Ilish");
		food.add("Kharoli");
		food.add("Khorisa");
		food.add("Koldil Chicken");
		food.add("Koldil Duck");
		food.add("Konir Dom");
		food.add("Lai Haq Maas");
		food.add("Litti");
		food.add("Maasor Tenga");
		food.add("Machher Jhol");
		food.add("Masor Koni");
		food.add("Masor Petu");
		food.add("Mishti Chholar Dal");
		food.add("Mishti Doi");
		food.add("Ou tenga Maas");
		food.add("Pakhala");
		food.add("Bhaji");
		food.add("Pani Pitha");
		food.add("Pantua");
		food.add("Payokh");
		food.add("Peda");
		food.add("Prawn malai curry");
		food.add("Red Rice");
		food.add("Rice");
		food.add("Rosgulla");
		food.add("Sabzi");
		food.add("Shondesh");
		food.add("Shukto");
		food.add("Sunga Pork");
		food.add("Tenga Doi");
		food.add("Til Pitha");
		food.add("congee");
		food.add("Shan people");
		food.add("Burma");
		food.add("Steamed rice");
		food.add("pig's trotters");
		food.add("soy sauce");
		food.add("five spice powder");
		food.add("Thai");
		food.add("shrimp paste");
		food.add("chicken biryani");
		food.add("Thai-Muslim");
		food.add("Khao man kai");
		food.add("red roast pork");
		food.add("Thai fried rice");
		food.add("American fried rice");
		food.add("Ocimum tenuiflorum");
		food.add("Canarium album");
		food.add("Thai");
		food.add("congee");
		food.add("red roast pork");
		food.add("Thai");
		food.add("wontons");
		food.add("green chicken curry");
		food.add("khanom chin");
		food.add("chicken feet");
		food.add("Khanom chin nam ngiao");
		food.add("Khanom chin namya");
		food.add("Khao soi");
		food.add("Chiang Mai");
		food.add("Chiang Rai province");
		food.add("Mae Sai");
		food.add("Chiang Rai Province");
		food.add("Teochew");
		food.add("Chinese");
		food.add("wide rice noodles");
		food.add("pork balls");
		food.add("fish balls");
		food.add("Drunken noodles");
		food.add("Kuai-tiao rat na");
		food.add("wide rice noodles");
		food.add("Boat noodles");
		food.add("cinnamon");
		food.add("star anise");
		food.add("Mi krop");
		food.add("Thai");
		food.add("Thai");
		food.add("drunken noodle");
		food.add("Phat si-io");
		food.add("Phat thai");
		food.add("Chinese chives");
		food.add("glass noodles");
		food.add("fusion dish");
		food.add("Yong Tau Foo");
		food.add("Chim chum");
		food.add("earthenware");
		food.add("kaffir lime");
		food.add("Thai holy basil");
		food.add("nam chim");
		food.add("Korean barbecue");
		food.add("hot pot");
		food.add("fish balls");
		food.add("nam chim");
		food.add("pla thu");
		food.add("nam phrik");
		food.add("shrimp paste");
		food.add("cha-om");
		food.add("khanom chin");
		food.add("crullers");
		food.add("youtiao");
		food.add("coconut jam");
		food.add("congee");
		food.add("Thai suki");
		food.add("hot pot");
		food.add("Snapper");
		food.add("Rastrelliger brachysoma");
		food.add("Thai curry");
		food.add("Acacia pennata");
		food.add("winter melon");
		food.add("Broussonetia");
		food.add("Kaeng hangle");
		food.add("Yellow curry");
		food.add("Kaeng khae");
		food.add("jackfruit");
		food.add("Green curry");
		food.add("fish balls");
		food.add("kaeng khiao wan luk chin pla");
		food.add("Kaeng khilek");
		food.add("Senna siamea");
		food.add("Thai");
		food.add("straw mushrooms");
		food.add("Garcinia");
		food.add("mangosteen");
		food.add("aspic");
		food.add("turmeric");
		food.add("bamboo shoots");
		food.add("kaeng som");
		food.add("yellow curry");
		food.add("Massaman curry");
		food.add("Lanna");
		food.add("Kaeng pa");
		food.add("wild boar");
		food.add("morning glory");
		food.add("Brassica rapa chinensis");
		food.add("Ficus virens");
		food.add("Gymnema");
		food.add("snakehead fish");
		food.add("Melientha");
		food.add("Phanaeng curry");
		food.add("Thai");
		food.add("Red curry");
		food.add("Red curry");
		food.add("Kaeng som");
		food.add("Snakehead fish");
		food.add("Thai");
		food.add("cha-om");
		food.add("Kaeng tai pla");
		food.add("Pangasius");
		food.add("water spinach");
		food.add("Colocasia gigantea");
		food.add("coconut heart");
		food.add("wolfberry");
		food.add("biryani");
		food.add("red roast pork");
		food.add("daikon");
		food.add("Tom chuet");
		food.add("glass noodles");
		food.add("Thai");
		food.add("Tom kha");
		food.add("galangal");
		food.add("bitter melon");
		food.add("pickled");
		food.add("Tom yam");
		food.add("lemon grass");
		food.add("galangal");
		food.add("kaffir lime");
		food.add("Phallus indusiatus");
		food.add("Koi pla");
		food.add("Isan");
		food.add("Opisthorchis viverrini");
		food.add("liver fluke");
		food.add("Larb");
		food.add("Lanna");
		food.add("spices");
		food.add("tripe");
		food.add("Mu nam tok");
		food.add("larb");
		food.add("culantro");
		food.add("shallots");
		food.add("bird's eye chili");
		food.add("culantro");
		food.add("shallots");
		food.add("bird's eye chili");
		food.add("Vietnamese coriander");
		food.add("spearmint");
		food.add("pla ra");
		food.add("Spondias mombin");
		food.add("Lao people");
		food.add("Laos");
		food.add("Isan");
		food.add("Green papaya salad");
		food.add("jackfruit");
		food.add("Thai");
		food.add("sticky rice");
		food.add("mango");
		food.add("som tam");
		food.add("pomelo");
		food.add("Somanniathelphusa");
		food.add("shallots");
		food.add("blood cockles");
		food.add("Curcuma zedoaria");
		food.add("Thai");
		food.add("Vietnamese sausage");
		food.add("Diplazium esculentum");
		food.add("pla duk");
		food.add("short mackerel");
		food.add("pork cracklings");
		food.add("cellophane noodles");
		food.add("Cloud ear fungus");
		food.add("Thai Chinese");
		food.add("Sichuan");
		food.add("Kung Pao chicken");
		food.add("Parkia speciosa");
		food.add("African basil");
		food.add("Phak bung fai daeng");
		food.add("water spinach");
		food.add("yellow bean sauce");
		food.add("oyster sauce");
		food.add("shiitake");
		food.add("luffa");
		food.add("gailan");
		food.add("Chinese broccoli");
		food.add("Brussels sprouts");
		food.add("kale");
		food.add("oyster sauce");
		food.add("shoots");
		food.add("chayote");
		food.add("soft-shell crab");
		food.add("Pea eggplant");
		food.add("Barramundi");
		food.add("mung bean");
		food.add("pandan");
		food.add("turmeric");
		food.add("Khaep mu");
		food.add("Giant snakehead");
		food.add("Clown Knifefish");
		food.add("Boesenbergia rotunda");
		food.add("Nile Tilapia");
		food.add("turmeric");
		food.add("Thai");
		food.add("souffl�");
		food.add("Kai yang");
		food.add("Isan");
		food.add("as round balls");
		food.add("bird's eye chillies");
		food.add("Sai ua");
		food.add("Jute");
		food.add("congee");
		food.add("samphire");
		food.add("p�t�");
		food.add("souffl�");
		food.add("p�t�");
		food.add("souffl�");
		food.add("Pla nueng manao");
		food.add("Thai");
		food.add("five-spice powder");
		food.add("Nam chim");
		food.add("spicy");
		food.add("nam chim");
		food.add("Nam chim");
		food.add("Peanut sauce");
		food.add("satay");
		food.add("fish sauce");
		food.add("bird's eye chillies");
		food.add("Nam phrik kapi");
		food.add("shrimp paste");
		food.add("pea sized aubergines");
		food.add("galangal");
		food.add("Spondias mombin");
		food.add("Nam phrik num");
		food.add("Nam phrik ong");
		food.add("Bolognese sauce");
		food.add("Nam phrik phao");
		food.add("Tom yam");
		food.add("Parathelphusidae");
		food.add("Sriracha sauce");
		food.add("hot sauce");
		food.add("Si Racha");
		food.add("five-spice powder");
		food.add("roti canai");
		food.add("roti prata");
		food.add("Indian");
		food.add("flatbread");
		food.add("crickets");
		food.add("Gryllus bimaculatus");
		food.add("Acheta domesticus");
		food.add("Smoked");
		food.add("Siu mai");
		food.add("dumplings");
		food.add("Cantonese");
		food.add("dish of the Teochew people");
		food.add("Teochew language");
		food.add("garlic chives");
		food.add("cr�pe");
		food.add("Miang kham");
		food.add("holy basil");
		food.add("cuttlefish");
		food.add("Satay");
		food.add("Knife fish (pla krai)");
		food.add("phak chi");
		food.add("water chestnut");
		food.add("plum sauce");
		food.add("pupae");
		food.add("silkworms");
		food.add("Grass jelly");
		food.add("egg yolk");
		food.add("sangkhaya");
		food.add("royal court of Ayutthaya");
		food.add("Maria Guyomar de Pinha");
		food.add("Taro root");
		food.add("Khanom chan");
		food.add("rice flour");
		food.add("tapioca flour");
		food.add("pandan");
		food.add("jasmine");
		food.add("kueh");
		food.add("Khanom priak phun");
		food.add("rice flour");
		food.add("tapioca flour");
		food.add("Jasmine");
		food.add("agar");
		food.add("coconut jam");
		food.add("Khao tom mat");
		food.add("monks");
		food.add("Pandan");
		food.add("cendol");
		food.add("Sangkhaya fak thong");
		food.add("custard");
		food.add("coconut jam");
		food.add("pastel de nata");
		food.add("Topioca Balls with Pork Filling");
		food.add("Tapioca Balls with Pork Filling");
		food.add("Kow Griep Pag Mor");
		food.add("Thong yip");
		food.add("Cha yen");
		food.add("condensed milk");
		food.add("kopi tiam");
		food.add("robusta coffee");
		food.add("steeping the grounds");
		food.add("Krating Daeng");
		food.add("energy drink");
		food.add("Red Bull");
		food.add("glutinous rice");
		food.add("moonshine");
		food.add("Mekhong whiskey");
		food.add("sugarcane");
		food.add("Centella asiatica");
		food.add("Clitoria ternatea");
		food.add("punch");
		food.add("slush puppie");
		food.add("punch");
		food.add("Lemongrass");
		food.add("Oliang");
		food.add("ice coffee");
		food.add("Teochew");
		food.add("Sang Som");
		food.add("Satho");
		food.add("rice wine");
		food.add("Isan");
		food.add("Chicken fried steak");
		food.add("breaded cutlet");
		food.add("steak");
		food.add("cube steak");
		food.add("seasoned");
		food.add("flour");
		food.add("pan-fried");
		food.add("Southern cuisine");
		food.add("Fatback");
		food.add("cured");
		food.add("pork");
		food.add("seasoning");
		food.add("Fried chicken");
		food.add("chicken");
		food.add("broiler");
		food.add("battered");
		food.add("pan-fried");
		food.add("deep fried");
		food.add("pressure fried");
		food.add("seasoned");
		food.add("breading");
		food.add("Chicken and waffles");
		food.add("Fried fish");
		food.add("catfish");
		food.add("whiting");
		food.add("porgies");
		food.add("bluegill");
		food.add("cornmeal");
		food.add("Ham hocks");
		food.add("smoked");
		food.add("braising");
		food.add("Hog Jowl");
		food.add("Cured");
		food.add("smoked");
		food.add("bacon");
		food.add("guanciale");
		food.add("Hog maw");
		food.add("pig");
		food.add("chitterlings");
		food.add("Offal");
		food.add("chitterlings");
		food.add("vinegar");
		food.add("parboiled");
		food.add("battered");
		food.add("hog maws");
		food.add("Ox tails");
		food.add("tail");
		food.add("cattle");
		food.add("gelatin");
		food.add("stew");
		food.add("braised");
		food.add("Pickled pigs feet");
		food.add("pickled");
		food.add("vinegar");
		food.add("Pigs feet");
		food.add("pigs");
		food.add("Pork");
		food.add("ham");
		food.add("bacon");
		food.add("flavoring");
		food.add("legumes");
		food.add("gravys");
		food.add("sauces");
		food.add("Pork ribs");
		food.add("ribcage");
		food.add("domestic pig");
		food.add("smoking");
		food.add("grilling");
		food.add("baking");
		food.add("barbecue");
		food.add("Poultry");
		food.add("giblet");
		food.add("liver");
		food.add("gizzards");
		food.add("Turkey");
		food.add("Black-eyed peas");
		food.add("rice and beans");
		food.add("Collard greens");
		food.add("staple");
		food.add("turnip");
		food.add("spinach");
		food.add("mustard");
		food.add("smoked");
		food.add("ham hocks");
		food.add("fatback");
		food.add("onions");
		food.add("Hoppin' John");
		food.add("Southern United States");
		food.add("black-eyed peas");
		food.add("field peas");
		food.add("rice");
		food.add("bacon");
		food.add("ham hock");
		food.add("fatback");
		food.add("country sausage");
		food.add("green peppers");
		food.add("vinegar");
		food.add("spices");
		food.add("Mustard greens");
		food.add("mustard plant");
		food.add("kale");
		food.add("Okra");
		food.add("Sweet potatoes");
		food.add("parboiled");
		food.add("candied");
		food.add("candied");
		food.add("Turnip greens");
		food.add("leaves");
		food.add("mustard greens");
		food.add("Cornbread");
		food.add("quickbread");
		food.add("skillet");
		food.add("buttermilk");
		food.add("bacon");
		food.add("Grits");
		food.add("Hoecake");
		food.add("shovel");
		food.add("hoe");
		food.add("Hushpuppies");
		food.add("deep-fried");
		food.add("buttermilk");
		food.add("scallion");
		food.add("corn");
		food.add("peppers");
		food.add("Cobbler");
		food.add("Pie");
		food.add("pecan pie");
		food.add("Sweet potato pie");
		food.add("Parboiled");
		food.add("pureed");
		food.add("pumpkin pie");
		
		
		
		Map<String, Object> documentMap = new HashMap<String, Object>();
		documentMap.put("wordsList", food);
		
		businessColl.insert(new BasicDBObject(documentMap));
		
	}

}