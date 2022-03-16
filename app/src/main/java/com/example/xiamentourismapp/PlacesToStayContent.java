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

public class PlacesToStayContent extends Fragment {
    String title, rating, description, tag, address, wifi, parking, directionURL, shareURL, websiteURL;
    // creating object of ViewPager
    ViewPager viewPager;
    // images array
    int[] images;
    // Creating Object of ViewPagerAdapter
    ViewPagerAdapter viewPagerAdapter;
    private TextView tv_title, tv_rating, tv_description, tv_tag, tv_address, tv_wifi, tv_parking, tv_btnticket;
    private ImageButton btn_share, btn_direction, btn_website, btn_back;
    private RelativeLayout rl_share, rl_direction, rl_website;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title = getArguments().getString("Title");
        rating = getArguments().getString("Rating");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.placesrostay_content_fragment,container,false);
        // link widgets
        tv_title = (TextView) view.findViewById(R.id.tv_title);
        rl_direction = view.findViewById(R.id.rl_direction);
        rl_website = view.findViewById(R.id.rl_website);
        rl_share = view.findViewById(R.id.rl_share);
        tv_rating = (TextView) view.findViewById(R.id.card_rating);
        tv_tag = (TextView) view.findViewById(R.id.tv_tags);
        tv_address = (TextView) view.findViewById(R.id.tv_address);
        tv_wifi = (TextView) view.findViewById(R.id.tv_wifi);
        tv_parking = (TextView) view.findViewById(R.id.tv_parking);
        tv_description = (TextView) view.findViewById(R.id.detail_description);

        switch(title){
            case "Pan Pacific Xiamen":
                images = new int[] {R.drawable.pan2, R.drawable.pan1, R.drawable.pan3, R.drawable.pan4, R.drawable.pan5};
                description = "Pan Pacific Xiamen is a five-star hotel belongs to Pan Pacific Hotels Group in Singapore. It only takes about 10-minutes walk to International Cruise Terminal (ferry to Gulangyu Island). The hotel is ideally located at only 100 meters away from the Metro line 2 Jianye Road Station, around 700 meters away from Xiamen Municipal Government.\n\n Popular sites such as Mountains-to-Sea Trail, Coffer/Bar Street, Yundang Lake, Bay Park and exotic cuisines are also around the hotel. You can enjoy a relaxing lifestyle here.\n\n Moreover, it is quite convenient to reach attractions such as Xiamen University, Zhongshan Road, etc., it only takes about 15-20 minutes by taxi. The hotel has 354 comfortable and elegant guest rooms, suites and high-level serviced apartments, with rooms ranging from 35 square meters. Stay at the hotel's high-rise room type to overlook the beautiful coastal scenery of Xiamen, and explore the depths of southern Fujian.";
                websiteURL = "https://www.panpacific.com/en/hotels-and-resorts/pp-xiamen.html";
                directionURL = "geo:24.4783434,118.0801823?q=Pan%20Pacific%20Xiamen";
                shareURL = "https://goo.gl/maps/D8nzXs2QFdyktBrw6";
                tag = "5 Star Hotel";
                address = "19 Hubin Bei Road, Xiamen, Fujian, China 361012";
                wifi = "Free High Speed Internet (Wifi)";
                parking = "Free Parking";
                break;
            case "Swiss Grand Xiamen":
                images = new int[]{R.drawable.swiss1, R.drawable.swiss2, R.drawable.swiss3, R.drawable.swiss4, R.drawable.swiss5};
                description = "Located in the heart of the city, overlooking the historical Gulangyu Island and its surrounding waters, the Swiss Grand Xiamen is within easy access of business, sightseeing, shopping and entertainments hubs. It is 15 minutes from Xiamen Gaoqi International Airport, 20 minutes from the Xiamen International Conference and Exhibition Centre, 10 minutes from the railway station and just 5 minutes by foot from the ferry terminal.\n\n The Swiss Grand Xiamen is a contemporary yet classic upscale hotel that offers the savvy business or leisure traveler ultimate comfort and style with breathtaking views.The Swiss Grand Xiamen stand 28 stories tall and features 588 guest room. Stay connected in comfort and style. \n\nIndulge in the comfort of our rooms with Suisse signature bedding, complimentary WIFI and internet access, and rainforest showers. Club Chine Executive Floors are from Levels 24-28 with a spacious Club Lounge on Levels 26 and 27, pampering discerning business travelers with privileges and benefits.";
                websiteURL = "http://www.swissgrandxiamen.com.cn/en";
                shareURL = "https://goo.gl/maps/2o21xUMCZ9GDRWHV7";
                directionURL = "geo:24.4499548,118.0770443?q=Swiss%20International%20Hotel%20Xiamen";
                tag = "5 Star Hotel";
                address = "No.12 Lujiang Avenue, Xiamen 361001 China";
                wifi = "Free Wifi";
                parking = "Free Parking";
                break;
            case "Shangri-La Xiamen":
                description = "Facing the stunning coastline, Shangri-La Hotel Xiamen is located in the emerging international business centre in the east of Xiamen. It is just 500 m from Guanyinshan Metro Station, and a short 5-minute walk from the beach and an amusement park.\n" +
                        "\n" +
                        "The hotel is about 5 minutes' drive from the Wanda Shopping Mall. It also enjoys a convenient access to Xiamen Conference Centre in a 10-minute drive and to Xiamen Gaoqi International Airport in 20 minutes. The famous Zengcuo'an Bathing Spot is 10 km away.\n" +
                        "\n" +
                        "Every room in Shangri-La Hotel Xiamen features floor-to-ceiling windows with city or sea views. All rooms are air-conditioned and equipped with a flat-screen TV and electric kettle. For guests' comfort, bathrobes, slippers, free toiletries and a private bathroom are provided.\n" +
                        "\n" +
                        "Entertainment facilities include an indoor heated pool, a state-of-the-art gym, sauna, steam facilities and spa service. There is also a 530-square-metre indoor kids' club which is equipped with a variety of children's entertainment facilities, movie screening rooms, handicraft workshops and mini restaurants. Theme parties and family classes are held on a regular basis.\n" +
                        "\n" +
                        "Featuring an open-style kitchen, the all-day-dining restaurant - Café Amoy - serves quality international cuisines. The stylish Chinese restaurant, Fu Gong, provides menus of authentic Cantonese cuisines and local specialities. The Lobby Lounge serves a good selection of local snacks, and outdoor barbecue at night fall.";
                images = new int[] {R.drawable.shangri_lang, R.drawable.shangri_lang2, R.drawable.shangri_lang3, R.drawable.shangri_lang4, R.drawable.shangri_lang5};
                websiteURL = "https://www.shangri-la.com/en/xiamen/shangrila/";
                shareURL = "https://goo.gl/maps/v9uMET1wE6MWAQwk8";
                directionURL = "geo:24.49717,118.1878013?q=Shangri-La%20Xiamen";
                tag = "4 Star Hotel";
                address = "No.168 Taidong Road, Guanyinshan International Business Centre, Siming District, Xiamen 361008 China";
                wifi = "Free High Speed Internet (Wifi)";
                parking = "Free Parking";
                break;
            case "Joyze Hotel Xiamen":
                images = new int[] {R.drawable.joyze1, R.drawable.joyze, R.drawable.joyze2, R.drawable.joyze3, R.drawable.joyze4};
                tag = "4 Star Hotel";
                address = "No.6-8, Longhushan Road Zengcuoan,Siming District, Xiamen 361005 China";
                wifi = "Free High Speed Internet (Wifi)";
                parking = "Free Parking";
                websiteURL = null;
                directionURL = "geo:24.428707,118.1177913?q=Joyze%20Hotel%20Xiamen";
                shareURL = "https://goo.gl/maps/naiTc9ojN7h24MM58";
                description = "Joyze Hotel Xiamen, Curio Collection By Hilton is situated in Xiamen, 500 m from Pearl Public Beach and 900 m from Zengcuo'an Bathing Spot. Among the various facilities are an outdoor swimming pool and a fitness centre.\n" +
                        "\n" +
                        "The hotel offers 215 chic guest rooms and suites designed in traditional Fujian style with modern fashionable element. All units come with cosy and high-quality beddings. Other amenities including a 49-inch HD TV, Bluetooth speaker and capsule coffee machine. The spacious bathroom offers a spa experience for all guests and the automatic toilet creates a joyful moment. Through the wide floor-to-ceiling window, guests can enjoy the stunning Dongping Mountain view, attractive city view and panoramic coastline.\n" +
                        "\n" +
                        "With staff speaking English and Chinese, round-the-clock guidance is available at the 24-hour front desk. The 24-hour fitness centre is fitted with the latest gym equipment. The infinity pool provides guests a place to unwind. The property offers chargeable personalised trip plan to help you explore Xiamen.\n" +
                        "\n" +
                        "The property has a restaurant featuring Asian food, a restaurant and bar providing food and drinks and a lobby bar.\n" +
                        "\n" +
                        "Joyze Hotel Xiamen is closed to Xiamen Universiaty and is only a 5-minute drive away from Xiamen Botanical Garden. The nearest airport is Xiamen Gaoqi International Airport, 20 minutes' car journey away.";
                break;
            case "Riyuegu Hotsprings Resort":
                tag = "Resort, Hotsprings";
                images = new int[]{R.drawable.hotspring3, R.drawable.hotspring1, R.drawable.hotspring2, R.drawable.hotspring4, R.drawable.hotspring5};
                wifi = "Free Wifi";
                address = "1888 Fulian Road, Haicang District, Hai Cang District, Xiamen, China, 361027";
                parking = null;
                shareURL = "https://goo.gl/maps/Jn6smExCmuS5Lxkm6";
                directionURL = "geo:24.557802,117.9390423?q=Riyuegu%20Hotsprings%20Resort%20Haicang%20District%20Xiamen%20Fujian";
                websiteURL = "http://www.riyuegu.com/EN/sheshi.aspx";
                description = "If you're looking to relax and unwind while in Xiamen, the Riyuegu Hotsprings Resort is definitely a must-try destination. Simply hop on the free shuttle bus that departs every hour from 10:00am to 12:00am from the Xiamen Ferry Terminal and soon enough you'll reach the resort, nestled in the shadows of the Tianzhu Mountains.\n\n Riyuegu Hotsprings Resort boasts of several indoor and outdoor hotspring pools as well as a full-service spa. There is also a bar area where you can lounge around and maybe have a drink or two.";
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
        if(wifi != null){
            tv_wifi.setText(wifi);
        }
        else {
            tv_wifi.setVisibility(View.GONE);
        }
        if(parking != null){
            tv_parking.setText(parking);
        }else {
            tv_parking.setVisibility(View.GONE);
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

        btn_website = (ImageButton) view.findViewById(R.id.btn_website);
        if (websiteURL != null) {
            btn_website.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent webIntent = new Intent(Intent.ACTION_VIEW);
                    webIntent.setData(Uri.parse(websiteURL));
                    startActivity(Intent.createChooser(webIntent, title));
                }
            });
        } else {
            rl_website.setVisibility(View.GONE);
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
