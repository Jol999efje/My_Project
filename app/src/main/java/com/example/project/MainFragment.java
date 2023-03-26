package com.example.project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {
    RecyclerView recyclerView;
    Adapter adapter;
  //  Adapter adapter2;
    View v;
    TextView get_search;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<Data> DataArrayList;
    private String[] NameList;
    private int[] ImageList;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    //    recyclerView=getView().findViewById(R.id.recycler_view);
    //    adapter=new Adapter(getActivity());
    //    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    //    recyclerView.setAdapter(adapter);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_main, container, false);
        get_search= v.findViewById(R.id.get_search);
        Bundle bundle=this.getArguments();
        String get_keyword=bundle.getString("editText");
        get_search.setText(get_keyword );

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        
        dataInitialize();

        recyclerView=view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        Adapter adapter=new Adapter(getContext(),DataArrayList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private void dataInitialize() {
        DataArrayList=new ArrayList<>();
        NameList =new String[]{
               getString(R.string.name1) ,
                getString(R.string.name2),
                getString(R.string.name3)
        };

        ImageList =new int[]{
                R.drawable.img_2969,
                R.drawable.img_2970,
                R.drawable.img_2972

        };
        for (int i=0;i<NameList.length;i++){
            Data data=new Data(ImageList[i], NameList[i]);
            DataArrayList.add(data);
        }

    }
}