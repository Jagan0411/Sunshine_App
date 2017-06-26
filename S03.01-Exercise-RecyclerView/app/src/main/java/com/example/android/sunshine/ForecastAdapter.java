package com.example.android.sunshine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by harish on 26-06-2017.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder> {

    private String mWeatherData[];

    public ForecastAdapter()
    {

    }


    public class ForecastAdapterViewHolder extends RecyclerView.ViewHolder {

        public final TextView mWeatherTextView;

        public ForecastAdapterViewHolder(View view)
        {
            super(view);
            mWeatherTextView = (TextView) view.findViewById(R.id.tv_weather_data);
        }

    }

    @Override
    public ForecastAdapter.ForecastAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int listItemId = R.layout.forecast_list_item;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        boolean attachParent = false;

        View view = layoutInflater.inflate(listItemId,parent,attachParent);
        return new ForecastAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ForecastAdapter.ForecastAdapterViewHolder holder, int position) {

        String weather_now = mWeatherData[position];
        holder.mWeatherTextView.setText(weather_now);

    }

    @Override
    public int getItemCount() {
        if(null == mWeatherData)
        {
            return 0;
        }
        return mWeatherData.length;
    }

    void setWeatherData(String weatherData[])
    {
        mWeatherData = weatherData;
        notifyDataSetChanged();
    }

}
