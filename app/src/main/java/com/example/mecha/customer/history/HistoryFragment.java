package com.example.mecha.customer.history;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mecha.R;
import com.google.android.material.tabs.TabLayout;

public class HistoryFragment extends Fragment {

    private TabLayout tabLayoutHistory;
    private ViewPager viewPagerHistory;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        View rootView = inflater.inflate(R.layout.activity_history_tab, container, false);
        View rootView = inflater.inflate(R.layout.fragment_history, container, false);

        tabLayoutHistory = rootView.findViewById(R.id.tabHistory);
        viewPagerHistory = rootView.findViewById(R.id.viewPagerHistory);

        tabLayoutHistory.setupWithViewPager(viewPagerHistory);
        VPHistoryAdapter vpHistoryAdapter = new VPHistoryAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpHistoryAdapter.addFragment(new OrdersFragment(), "Orders");
        vpHistoryAdapter.addFragment(new PurchasesFragment(), "Purchases");
        viewPagerHistory.setAdapter(vpHistoryAdapter);

        return rootView;
    }
}