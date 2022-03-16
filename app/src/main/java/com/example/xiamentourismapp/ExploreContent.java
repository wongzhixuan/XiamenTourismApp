package com.example.xiamentourismapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class ExploreContent extends Fragment {
    String title, rating, description, tag, address, ticket, time, directionURL, shareURL, ticketURL;
    // creating object of ViewPager
    ViewPager viewPager;
    // images array
    int[] images;
    // Creating Object of ViewPagerAdapter
    ViewPagerAdapter viewPagerAdapter;
    private TextView tv_title, tv_rating, tv_description, tv_tag, tv_address, tv_ticket, tv_time;
    private ImageButton btn_share, btn_direction, btn_ticket, btn_back;
    private RelativeLayout rl_share, rl_direction, rl_ticket;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title = getArguments().getString("Title");
        rating = getArguments().getString("Rating");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.explore_content_fragment, container, false);
        // link widgets
        tv_title = (TextView) view.findViewById(R.id.tv_title);
        rl_direction = view.findViewById(R.id.rl_direction);
        rl_ticket = view.findViewById(R.id.rl_ticket);
        rl_share = view.findViewById(R.id.rl_share);
        tv_rating = (TextView) view.findViewById(R.id.card_rating);
        tv_tag = (TextView) view.findViewById(R.id.tv_tags);
        tv_address = (TextView) view.findViewById(R.id.tv_address);
        tv_ticket = (TextView) view.findViewById(R.id.tv_ticket);
        tv_time = (TextView) view.findViewById(R.id.tv_time);
        tv_description = (TextView) view.findViewById(R.id.detail_description);

        switch (title) {
            case "Gulangyu Island":
                images = new int[]{R.drawable.gulangyu, R.drawable.gulangyu2, R.drawable.gulangyu3, R.drawable.gulangyu4, R.drawable.gulangyu5, R.drawable.gulangyu6};
                tag = "Island, Sights&Landmarks";
                address = "Siming District, Xiamen 361001, China";
                time = "12:00 AM - 11:59 PM";
                ticket = "Ferry Between Xiamen City and Gulangyu";
                description = "The Gulangyu, Gulang Island, or Kulangsu is a pedestrian-only island off the coast of Xiamen, Fujian Province in southeastern China. A UNESCO World Cultural Heritage Site, the island is about 2 km2 (0.77 sq mi) in the area and is reached by an 8-minute ferry ride from downtown Xiamen. Although only about 20,000 people live on the island, Gulangyu is a major domestic tourist destination, attracting more than 10 million visitors per year, and making it one of China's most visited tourist attractions.  The only vehicles permitted are small electric buggies and electric government service vehicles.\n\n" +
                        "Visitors can reach Gulangyu by ferry from the ferry terminal in Xiamen. Gulangyu Island is renowned for its beaches, winding lanes, and rich architecture. The island is on China's list of National Scenic Spots and is classified as a 5A tourist attraction by the China National Tourism Administration (CNTA). It ranks at the top of the list of the ten most scenic areas in the province.";
                directionURL = "geo:24.4463166,118.0487224?q=gulangyu";
                shareURL = "https://goo.gl/maps/dnhZTf2QyR6YZN2DA";
                ticketURL = "https://www.chinadiscovery.com/xiamen-tours/transportation/get-to-gulangyu-island.html";
                break;
            case "Yuanlin Botanical Garden":
                images = new int[]{R.drawable.yuanlin_botanical_garden, R.drawable.yuanlin_garden, R.drawable.yuanlin_garden2, R.drawable.yuanlin_garden3, R.drawable.yuanlin_garden4, R.drawable.yuanlin_garden6};
                tag = "Garden, Parks";
                address = "No.25 Huyuan Road, Siming District, Xiamen 361001, China";
                time = "6:30 AM - 6:00 PM";
                ticket = "RMB 30/person";
                description = "Xiamen Botanical Garden, also known as Wanshi Botanical Garden is set amidst Wanshi Mountain in the Southeastern part of Xiamen Island. It is an integral part of the Gulangyu Islet – Wanshi Mountain National Key Scenic Spot, covering an area of 4.93 square kilometers. \n"
                        + "The garden has more than ten segments that showcase a variety of rare plants, including Chinese larch, hoop pine, strangely-shaped cacti, and other exotic foliage. In addition to the unique foliage, the park also brings together many natural wonders and human creations, including stone carvings, lakes, lawns, temples, and other attractions.";
                directionURL = "geo:24.4463709,118.0981595?q=Xiamen%20Botanical%20Garden";
                shareURL = "https://goo.gl/maps/3tnbQmnpuEGjaVpP8";
                ticketURL = "https://www.xiamenbg.com/index.php?m=content&c=index&a=show&catid=66&id=1763";
                break;
            case "Kulangsu Huandao Road":
                images = new int[]{R.drawable.kulangsu, R.drawable.kulangsu_road1, R.drawable.kulangsu_huandao_road, R.drawable.kulangsu_huandao_road2, R.drawable.kulangsu_huandao_road3, R.drawable.kulangsu_huandao_road6};
                tag = "Hiking Trails";
                address = "Siming District, Xiamen 361001, China";
                description = "Ride, drive, or walk along Kulangsu Huandao Road, a coastal road that takes in many of the UNESCO World Heritage-listed island's main sights.\n\n" +
                        "Following the coastline and feeding out into pedestrianized wooden walkways and cycle paths, the ring road offers extensive views of the coast, a scattering of popular beaches, and some seaside highlights, such as beach bars, souvenir shops, pavilions, and water sports rental companies. Consider hiring a bicycle from one of the many rental shops, as parts of the cycle track head straight down by the beach.";
                time = "12:00 AM - 11:59 PM";
                ticket = "No Tickets Required";
                ticketURL = null;
                shareURL = null;
                directionURL = null;
                break;
            case "Xiamen Bailuzhou Park":
                images = new int[]{R.drawable.bailuzhou, R.drawable.bailuzhou2, R.drawable.bailuzhou3, R.drawable.bailuzhou4, R.drawable.bailuzhou5};
                tag = "Parks";
                address = "No. 565, Bailuzhou Road, Siming District, Xiamen 361004, China";
                time = "12:00 AM - 11:59PM";
                ticket = "No Tickets Required";
                directionURL = "geo:24.47285563944606, 118.08923359115803?q=Bailuzhou%20Park";
                ticketURL = null;
                shareURL = "https://goo.gl/maps/gqqh64kZHNbmHjYMA";
                description = "Bailuzhou Park is also known as the Xiamen Open Square Park. The park has a great environment and is especially good for peaceful and quiet walks. You will find the park is divided into Central Park and West Park.\n\n In the West Park you will be able to find plenty of music options in the form of fountain squares and plazas. There is also a statue of the egret goddess located in the park. You will be able to find the statue at the south side of the park at the yacht dock. \n\n" +
                        "The statue consists of the goddess sitting on a rock as she combs her long beautiful hair. As she combs her hair she allows us to see her in all her beauty while carrying a small egret on her shoulders. The sculpture is a symbol of Xiamen.";
                break;
            case "South Putuo Temple":
                images = new int[]{R.drawable.southputuotemple, R.drawable.southputuotemple2, R.drawable.southputuotemple3, R.drawable.southputuotemple4, R.drawable.southputuotemple5};
                tag = "Religious Sites";
                time = "7:00 AM - 6:00 PM";
                address = "No.515 Siming South Road, Siming District, Xiamen 361005, China";
                shareURL = "https://goo.gl/maps/VxSXrop2qYA6ifGZ8";
                directionURL = "geo:24.440773,118.0946153?q=South%20Putuo%20Temple";
                ticketURL = null;
                ticket = "No Tickets Required";
                description = "South Putuo Temple is located adjacent to Xiamen University, so you can enjoy both sites in the same day. The temple originated was built during the Tang Dynasty and was rebuilt by the Qing Emperor Kangxi. Because like Puji Temple on Putuo Mountain it was also dedicated to Guanyin, it was given the name South Putuo Temple.\n\nIt is a Buddhist temple famous in southern Fujian and even across the whole country. This place is a must visit if you wish to pray. Behind the temple, you can find Wulao Mountain, one of the “Eight Major Landscapes” of Xiamen. Visitors are able to climb the mountain";
                break;
            case "Xiamen Piano Museum":
                images = new int[]{R.drawable.piano_musuem, R.drawable.piano_musuem2, R.drawable.piano_musuem3, R.drawable.piano_musuem4, R.drawable.piano_musuem5};
                tag = "Speciality Museum";
                address = "No.7 Ganghou Road, Siming District, Xiamen 361002, China";
                time = "8:00 AM - 5:30 PM";
                ticket = "RMB 30/person";
                ticketURL = null;
                shareURL = "https://goo.gl/maps/D32T1j3x8EepNmjW6";
                directionURL = "geo:24.439535,118.0668413?q=Gulangyu%20Piano%20Museum";
                description = "The Piano Museum is located on the Gulangyu Island in the Tide Viewing Tower of Shuzhuang Garden. The island is often known as the piano island simply because of the long-known popularity of pianos among the local people. This museum depicts the culture and history of pianos.\n\n Expert musicians, as well as uninitiated visitors, would be charmed by the beautiful pianos, the artistry involved in creating them, and the lovely music to come away more knowledgeable about the beauty and history of pianos.\n\n" +
                        "The museum exhibits more than 100 ancient pianos that are world-famous. The pianos have been collected from the Americas, Australia, Britain, Austria, and France. All pianos were collected by Hu Youyi, an overseas patriotic Chinese. He was born on Gulangyu Island.";
                break;
            case "Overseas Chinese Museum":
                images = new int[] {R.drawable.museum_chinese, R.drawable.museum_chinese2, R.drawable.museum_chinese3, R.drawable.museum_chinese4, R.drawable.museum_chinese5};
                tag = "Speciality Museums";
                address = "493 Siming S Rd, Siming District, Xiamen 361005, China";
                time = "Tues - Sunday: 9:30 AM - 4:30 PM";
                ticket = "No Tickets Required";
                ticketURL = null;
                directionURL = "geo:24.442124,118.0879653?q=Overseas%20Chinese%20Museum";
                shareURL = "https://goo.gl/maps/9rA2s6EVPHRyXSX97";
                description = "The Overseas Chinese Museum was established by Tan Kah Kee in 1956, a famous overseas Chinese leader. It is the only Chinese museum to be established by an overseas Chinese. The museum displays over 7000 cultural relics and is divided into six different sections.\n" +
                        "\n\n" +
                        "It includes the overseas Chinese story, the friendship between the overseas Chinese and host country people, the tragedies of the overseas Chinese prior to the liberation, review of the overseas Chinese policies, the present and the past of the overseas Chinese community, and the contribution done by overseas Chinese to China.";
                break;
            case "Zhongshan Road Walking Street":
                images = new int[] {R.drawable.zhongshan_street, R.drawable.zhongsha_street2, R.drawable.zhongshan3, R.drawable.zhongshan4, R.drawable.zhongshan5};
                tag = "Points of Interest & Landmarks, Historic Walking Areas";
                address = "Zhongshan Road, Siming District, Xiamen 361005, China";
                time = "12:00 AM - 11:59 PM";
                ticket = "No Tickets Required";
                ticketURL = null;
                directionURL = "geo:24.4539092,118.0799241?q=Zhong%20Shan%20Lu";
                shareURL = "https://goo.gl/maps/S8oejFyrLtsmXgkX6";
                description = "Zhongshan Road Pedestrian Street is a commercial street in Xiamen. Zhongshan Road is a symbol for Xiamen's prosperity. The buildings along Zhongshan Road are all verandas, popular in South China coastal regions. The verandas feature pink and creamy white as the main colors.\n\n With the passage of time, mottled walls and old wooden windows have imparted a special kind of quaintness on the buildings. At the same time, modern commercial buildings such as Paris Printemps are interspersed among them.";
                break;
            case "Zeng Cuo An Village":
                images = new int[] {R.drawable.zengcuoan1, R.drawable.zengcuoan2, R.drawable.zengcuoan3, R.drawable.zengcuo4, R.drawable.zengcuo5, R.drawable.zengcuo6};
                tag = "Points of Interest & Landmarks";
                address = "Siming District, Xiamen 361005, China";
                time = "12:00 AM - 11:59 PM";
                ticket = "No Tickets Required";
                ticketURL = null;
                directionURL = "geo:24.4341193,118.1160752?q=Zeng%20Cuo%20An%20Cun";
                shareURL = "https://goo.gl/maps/HssDz5zsGh6sbcbX8";
                description = "Zeng Cuo An Village is located on Xiamen's Huandao Road. It slowly transformed from a rustic coastal fishing village to today's popular and innovative cultural village. \n\nDespite all the hustle and bustle, it still retains its old charm today. You can make a pot of tea and sit on a old wooden rattan chair to view the sea breeze, or you can also take a walk through the alleys of the village to have some local delights and observe how locals go about their daily lives. With the sunlight shining through the vines over the top of your head and the smells of the salty sea breeze, you will enjoy this tranquility amidst the bustling city.";
                break;
            case "Shacha Mian":
                images = new int[] {R.drawable.shachamian, R.drawable.shachamian2, R.drawable.shachamian4};
                tag = "Noodles, Local Cuisine";
                address = null;
                time = null;
                ticket = null;
                directionURL = null;
                shareURL = null;
                description = "Sha Cha Mian or Sand Tea Noodles is quite popular in Xiamen and is sold in almost every noodle shop. The soup has a clay color due to the addition of pulverised peanuts, which make the dish aromatic. \n\nThe specialty of Sha Cha noodle is that its soup is made by Shacha sauce and pork or chicken bones soup, you can add any food materials you like in the noodle like stewed pig's liver, duck's tendon, pig's kidney, and dried tofu etc.";
                break;
            case "Fried Oysters Omelet":
                images = new int[] {R.drawable.friedoyster, R.drawable.friedoyster2, R.drawable.friedoyster3, R.drawable.friedoyster4};
                tag = "Snack, SeaFood, Local Cuisine";
                address = null;
                time = null;
                ticket = null;
                directionURL = null;
                shareURL = null;
                description = "Fried Oyster Omelet is a popular snack in Xiamen that is often sold in night markets. The dish consists of an omelet with a filling primarily composed of small oysters. Starch is mixed into the egg batter, giving the egg wrap a thicker consistency. Pork lard is often used to fry the omelet.";
                break;
            case "Tusundong":
                images = new int[] {R.drawable.tusungdong111,R.drawable.tusundong, R.drawable.tusundong2, R.drawable.tusundong3};
                tag = "Snack, SeaFood, Local Cuisine";
                address = null;
                time = null;
                ticket = null;
                directionURL = null;
                shareURL = null;
                description = "Main material of Sandworm Jelly is a kind of worm found in muddy seabed. Sea worm is cooked. As it contains gelatin, after being cooked, the gelatin is mixed with the water, and then poured into moulds before it forms to jelly when it gets cold.\n\n The worm jelly is served with garlic sauce, vinegar, radishes, mustard, and other pungent spices. It’s really good to taste and very rich in protein.";
                break;
            case "Jiangmu Duck":
                images = new int[] {R.drawable.duck4, R.drawable.duck1, R.drawable.duck2, R.drawable.duck3};
                tag = "Duck, Local Cuisine";
                address = null;
                time = null;
                ticket = null;
                directionURL = null;
                shareURL = null;
                description = "The duck is stir-fried in the pot for a while, then ginger root and rice wine are added and the ingredients are stewed. High heat and low heat are used to cook the pot and certain herbs that are good for health are added. Vegetables and noodles can be cooked in the pot too. \n\nJiangmu Duck is considered a Chinese food therapy. In the cold days in fall and winter, Jiangmu Duck can help to keep people warm.";
                break;
            case "Mianxianhu":
                images = new int[] {R.drawable.mianxianhu, R.drawable.mianxianhu2, R.drawable.mianxianhu3, R.drawable.mianxianhu4};
                tag = "Noodles, Breakfast";
                address = null;
                time = null;
                ticket = null;
                directionURL = null;
                shareURL = null;
                description = "Mianxiahuis a dish of mixed noodles cooked in stewed pork broth. It contains wheat noodles, rice noodles, and sweet potato starch noodles. Apart from noodles, chefs often add various ingredients, such as shrimp, celery leaves, egg, and pork intestines to add more flavor. Locals often order this as their breakfast together with youtiao (a deep-fried crispy wheat bar).";
                break;





        }

        // Initializing the ViewPager Object
        viewPager = (ViewPager) view.findViewById(R.id.viewpager_explore);

        // Initializing the ViewPagerAdapter
        viewPagerAdapter = new ViewPagerAdapter(getActivity(), images);

        // Adding the Adapter to the ViewPager
        viewPager.setAdapter(viewPagerAdapter);

        // set text
        tv_title.setText(title);
        tv_rating.setText(rating);
        tv_tag.setText(tag);
        if(address != null) {
            tv_address.setText(address);
        }
        else{
            tv_address.setVisibility(View.GONE);
        }
        if(ticket != null){
            tv_ticket.setText(ticket);
        }
        else {
            tv_ticket.setVisibility(View.GONE);
        }
        if(time != null){
            tv_time.setText(time);
        }else {
            tv_time.setVisibility(View.GONE);
        }
        tv_description.setText(description);

        btn_direction = (ImageButton) view.findViewById(R.id.btn_direction);
        if (directionURL != null) {
            btn_direction.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri direction = Uri.parse(directionURL);
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, direction);
                    mapIntent.setPackage("com.google.android.apps.maps");
                    if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                        startActivity(mapIntent);
                    } else {
                        Toast.makeText(getActivity(), "Cannot find any suitable application to handle request", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {
            rl_direction.setVisibility(View.GONE);
        }

        btn_ticket = (ImageButton) view.findViewById(R.id.btn_ticket);
        if (ticketURL != null) {
            btn_ticket.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent webIntent = new Intent(Intent.ACTION_VIEW);
                    webIntent.setData(Uri.parse(ticketURL));
                    startActivity(Intent.createChooser(webIntent, title));
                }
            });
        } else {
            rl_ticket.setVisibility(View.GONE);
        }
        btn_share = (ImageButton) view.findViewById(R.id.btn_share);
        if (shareURL != null) {
            btn_share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent sendIntent = new Intent(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, shareURL);
                    sendIntent.setType("text/plain");
                    // Show Sharesheet
                    startActivity(Intent.createChooser(sendIntent, null));
                }
            });
        } else {
            rl_share.setVisibility(View.GONE);
        }
        btn_back = view.findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().popBackStack();
            }
        });


        return view;
    }
}
