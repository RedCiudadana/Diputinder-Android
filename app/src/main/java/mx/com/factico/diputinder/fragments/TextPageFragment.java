package mx.com.factico.diputinder.fragments;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Locale;

import mx.com.factico.diputinder.R;
import mx.com.factico.diputinder.beans.Text;
import mx.com.factico.diputinder.utils.ScreenUtils;
import mx.com.factico.diputinder.views.CustomTextView;

/**
 * Created by zace3d on 18/05/15.
 */
public class TextPageFragment extends Fragment {
    public static final String TAG_CLASS = TextPageFragment.class.getName();

    private static final String TEXT = "text";
    private static final String INDEX = "index";

    private Text text;
    private int index;

    /**
     * Instances a new fragment with a background color and an index page.
     *
     * @param text  text
     * @param index index page
     * @return a new page
     */
    public static Fragment newInstance(int index, Text text) {

        // Instantiate a new fragment
        Fragment fragment = new TextPageFragment();

        // Save the parameters
        Bundle bundle = new Bundle();
        bundle.putInt(INDEX, index);
        bundle.putSerializable(TEXT, text);
        fragment.setArguments(bundle);
        fragment.setRetainInstance(true);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Load parameters when the initial creation of the fragment is done
        this.text = (getArguments() != null) ? (Text) getArguments().getSerializable(TEXT) : null;
        this.index = (getArguments() != null) ? getArguments().getInt(INDEX) : -1;
    }

    private ViewGroup rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_text, container, false);

        createView(rootView);

        return rootView;
    }

    private View createView(View view) {
        if (view != null) {
            Point point = ScreenUtils.getScreenSize(getActivity());
            int width = point.x / 7 * 6;
            int height = (int) ScreenUtils.convertDpToPixel(100, getActivity());

            int marginTop = (int) ScreenUtils.convertDpToPixel(50, getActivity());

            ImageView imageLogo = (ImageView) view.findViewById(R.id.text_image_logo);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(width, height);
            params.addRule(RelativeLayout.CENTER_HORIZONTAL);
            params.addRule(RelativeLayout.ABOVE, R.id.text_tv_title);
            params.setMargins(0, marginTop, 0, 0);
            imageLogo.setLayoutParams(params);

            if (index == 0)
                imageLogo.setImageResource(R.drawable.ic_liguepolitico);
            else if (index == 1)
                imageLogo.setImageResource(R.drawable.ic_mexicoquemerecemos);
            else if (index == 2)
                imageLogo.setImageResource(R.drawable.ic_3_de_3);
            else if (index == 3)
                imageLogo.setImageResource(R.drawable.ic_factico);
            else if (index == 4)
                imageLogo.setImageResource(R.drawable.ic_corazonroto);

            CustomTextView tvTitle = (CustomTextView) view.findViewById(R.id.text_tv_title);
            if (text.getTitle() != null && !text.getTitle().equals(""))
                tvTitle.setText(text.getTitle().toUpperCase(Locale.getDefault()));
            /*else
                tvTitle.setVisibility(View.GONE);*/

            CustomTextView tvContent = (CustomTextView) view.findViewById(R.id.text_tv_content);
            if (text.getContent() != null && !text.getContent().equals(""))
                tvContent.setText(text.getContent());
            /*else
                tvContent.setVisibility(View.GONE);*/

            ImageView ivBgr = (ImageView) view.findViewById(R.id.text_iv_bgr);
            //ivBgr.setImageResource(R.drawable.bgr_tutorial_candados);
            Bitmap bitmap = null;

            if (index == 0) {
                //bitmap = ImageUtils.decodeSampledBitmapFromResource(getResources(), R.drawable.tour_img_1, 100, 200);
            } else if (index == 1) {
                //bitmap = ImageUtils.decodeSampledBitmapFromResource(getResources(), R.drawable.tour_img_2, 100, 200);
            } else if (index == 2) {
                //bitmap = ImageUtils.decodeSampledBitmapFromResource(getResources(), R.drawable.tour_img_3, 100, 200);
            }

            if (bitmap != null) {
                /*Bitmap bitmapBlured = BlurFilter.fastblur(bitmap, 15);

                if (bitmapBlured != null)
                    ivBgr.setImageBitmap(bitmapBlured);*/
            }

        }

        return view;
    }
}