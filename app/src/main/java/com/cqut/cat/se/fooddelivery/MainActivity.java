package com.cqut.cat.se.fooddelivery;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.cqut.cat.se.fooddelivery.databinding.ActivityMainBinding;
import com.cqut.cat.se.fooddelivery.diy.GeneralActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends GeneralActivity implements BottomNavigationView.OnNavigationItemSelectedListener,
        BottomNavigationView.OnNavigationItemReselectedListener {

    private ActivityMainBinding mViews;
    private Fragment currentFragment;
    private MainViewModel mViewModel;
    private HomeFragment fragmentHome;
    private ExploreFragment fragmentExplore;
    private OrdersFragment fragmentOrders;
    private MoreFragment fragmentMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViews = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mViews.getRoot());

        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        if (mViewModel.itemId == 0) mViewModel.itemId = R.id.mainBottomNavHome;
        // 导航栏点击事件监听器，进行页面切换
        mViews.mainBottomNav.setOnNavigationItemSelectedListener(this);
        mViews.mainBottomNav.setSelectedItemId(mViewModel.itemId);
        mViews.mainBottomNav.setOnNavigationItemReselectedListener(this);
    }

    @Override
    protected void consumeInsets(GeneralActivity.WindowInsets insets) {
        BottomNavigationView nav = mViews.mainBottomNav;
        nav.setPadding(nav.getPaddingStart(), nav.getPaddingTop(), nav.getPaddingEnd(), insets.bottom);
    }

    private HomeFragment getFragmentHome() {
        if (fragmentHome == null) fragmentHome = HomeFragment.getInstance();
        return fragmentHome;
    }

    private ExploreFragment getFragmentExplore() {
        if (fragmentExplore == null) fragmentExplore = ExploreFragment.getInstance();
        return fragmentExplore;
    }

    private OrdersFragment getFragmentOrders() {
        if (fragmentOrders == null) fragmentOrders = OrdersFragment.newInstance();
        return fragmentOrders;
    }

    private MoreFragment getFragmentMore() {
        if (fragmentMore == null) fragmentMore = MoreFragment.newInstance();
        return fragmentMore;
    }

    private Fragment getNavFragment(MenuItem item){
        Fragment fragment;
        switch (item.getItemId()){
            case R.id.mainBottomNavExplore:
                fragment = getFragmentExplore();
                break;
            case R.id.mainBottomNavOrders:
                fragment = getFragmentOrders();
                break;
            case R.id.mainBottomNavMore:
                fragment = getFragmentMore();
                break;
            case R.id.mainBottomNavHome: default:
                fragment = getFragmentHome();
                break;
        }
        return fragment;
    }

    private MainPage getNavPage(MenuItem item){
        Fragment fragment = getNavFragment(item);
        return (MainPage) fragment;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        mViewModel.itemId = item.getItemId();
        Fragment fragment = getNavFragment(item);
        if (fragment == currentFragment) return true;

        // 以下：切换对应的页面
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        // 隐藏当前显示的页面
        if (currentFragment != null) transaction.hide(currentFragment);
        // 若已添加该 fragment 则将它显示出来；否则添加该 fragment
        if (fragment.isAdded()) transaction.show(fragment);
        else transaction.add(R.id.mainFragmentContainer, fragment);
        // 执行操作
        transaction.commit();
        // 当前显示的页面
        currentFragment = fragment;

        final MainPage page = (MainPage) fragment;
        page.onPageVisible();

        return true;
    }

    @Override
    public void onNavigationItemReselected(@NonNull MenuItem item) {
        MainPage page = getNavPage(item);
        page.onVisiblyClick();
    }

    public interface MainPage{

        /**
         * 切换至当前页面
         * 应当更新标题和工具栏选项
         */
        void onPageVisible();

        /**
         * 当前页面时，单击 tab
         * 应当回到顶部等
         * 若当前页面已处于顶部，可以进行刷新（双击 tab 事件）
         */
        void onVisiblyClick();

//        /**
//         * 用于标识 fragment
//         * @return tag
//         */
//        String getManageableTag();
    }
}
