package com.example.mecha.customer.history;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.mecha.R;
import com.google.android.material.tabs.TabLayout;

public class HistoryTabActivity extends AppCompatActivity {

    private TabLayout tabLayoutHistory;
    private ViewPager viewPagerHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_tab);

        tabLayoutHistory = findViewById(R.id.tabHistory);
        viewPagerHistory = findViewById(R.id.viewPagerHistory);

        tabLayoutHistory.setupWithViewPager(viewPagerHistory);
        VPHistoryAdapter vpHistoryAdapter = new VPHistoryAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpHistoryAdapter.addFragment(new OrdersFragment(), "Orders");
        vpHistoryAdapter.addFragment(new PurchasesFragment(), "Purchases");
        viewPagerHistory.setAdapter(vpHistoryAdapter);
    }
}