package com.example.mecha.mecha.mechaHistory;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mecha.R;
import com.example.mecha.customer.history.OrdersFragment;
import com.example.mecha.customer.history.PurchasesFragment;
import com.example.mecha.customer.history.VPHistoryAdapter;
import com.google.android.material.tabs.TabLayout;

public class MechaHistoryFragment extends Fragment {

    private TabLayout tabLayoutHistory;
    private ViewPager viewPagerHistory;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_mecha_history, container, false);

        tabLayoutHistory = rootView.findViewById(R.id.tabHistory);
        viewPagerHistory = rootView.findViewById(R.id.viewPagerHistory);

        tabLayoutHistory.setupWithViewPager(viewPagerHistory);
        VPHistoryAdapter vpHistoryAdapter = new VPHistoryAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpHistoryAdapter.addFragment(new MechaOrdersFragment(), "Orders");
        vpHistoryAdapter.addFragment(new MechaPurchasesFragment(), "Purchases");
        viewPagerHistory.setAdapter(vpHistoryAdapter);

        return rootView;
    }
}