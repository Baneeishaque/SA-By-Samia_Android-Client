package com.example.sa_by_samia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class SliderAdapter_2 extends RecyclerView.Adapter<SliderAdapter_2.ViewHolder> {

    private List<SliderImage_2> pageList;
    private ViewPager2 viewPager2;

    public SliderAdapter_2(List<SliderImage_2> pageList, ViewPager2 viewPager2){

        this.pageList = pageList;
        this.viewPager2 = this.viewPager2;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewpager_2,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.setImage(pageList.get(position));

    }

    @Override
    public int getItemCount() {
        return pageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private RoundedImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.viewPagerImage2);

        }

        public void setImage(SliderImage_2 sliderImage_2) {

            imageView.setImageResource(sliderImage_2.getImage());

        }

    }
}
