package temple.edu;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;




public class BookDetailFragment extends Fragment {
    private Item item;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        item = (Item) getArguments().getSerializable("item");

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_detail, container, false);
        TextView bdTitle = (TextView) view.findViewById(R.id.BDtitle);
        TextView bdBody = (TextView) view.findViewById(R.id.BDbody);
        bdTitle.setText(item.getTitle());
        bdBody.setText(item.getBody());
        return view;
    }

    // ItemDetailFragment.newInstance(item)
    public static BookDetailFragment newInstance(Item item) {
        BookDetailFragment frag = new BookDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable("item", item);
        frag.setArguments(args);
        return frag;
    }
}
