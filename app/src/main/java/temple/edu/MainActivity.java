package temple.edu;

import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements BookListFragment.OnItemSelectedListener {
    private boolean isTwoPane = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.viewPager);  //get the id of the vivepager
        if(viewPager != null){ //check
            viewPager.setAdapter(new MyViewPagerAdapter(MainActivity.this, Item.getItems()));
        }else{
            determinePaneLayout();
        }

    }
    private void determinePaneLayout(){
        FrameLayout fragmentItemDetail = (FrameLayout) findViewById(R.id.flDetailContainer);
        if(fragmentItemDetail != null){
            isTwoPane = true; //set to true
            BookListFragment fragmentBookList =
                    (BookListFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentItemsList);
            fragmentBookList.setActivateOnItemClick(true);
        }
    }

    @Override
    public void onItemSelected(Item item){
        if(isTwoPane){ //single activity with kist detail
            //replace fram layout with correct detail fragment
            BookDetailFragment fragmentItem = BookDetailFragment.newInstance(item);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flDetailContainer, fragmentItem);
            ft.commit();
        }else{
            Intent i = new Intent(this, BookDetailActivity.class);
            i.putExtra("item", item);
            startActivity(i);
        }
    }
    protected class MyViewPagerAdapter extends PagerAdapter{
        private List<Item> books;
        private Context context;

        MyViewPagerAdapter(Context context, List<Item> books){
            this.context = context;
            this.books = books;
        }
        @Override
        public int getCount(){

            return books.size();
        }
        @Override
        public boolean isViewFromObject(View view, Object object){
            return view == object;

        }
        @Override
        public Object instantiateItem(ViewGroup container, int position){
            LayoutInflater inflater = LayoutInflater.from(context);
            ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.fragment_book_detail,container,false);
            TextView title = layout.findViewById(R.id.BDtitle);
            TextView body = layout.findViewById(R.id.BDbody);
            title.setText(books.get(position).getTitle());
            body.setText(books.get(position).getBody());
            container.addView(layout);
            return layout;
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object){
            container.removeView((View) object);

        }
    }

}
