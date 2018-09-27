package com.callor.woo_project.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.callor.woo_project.R;
import com.callor.woo_project.models.GoDataListVO;

import java.util.List;

public class GoDataViewAdapter extends RecyclerView.Adapter{

    List<GoDataListVO> goDataLists ;
    Context context ;

    public GoDataViewAdapter(List<GoDataListVO> goDataLists) {
        this.goDataLists = goDataLists;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_go_data,parent,false);
        return new GoDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        GoDataViewHolder goDataViewHolder =(GoDataViewHolder)holder;

        GoDataListVO vo = goDataLists.get(position);

        String servName = "<b><font color=blue>" + vo.getServNm() + "</font><b>" ;
        goDataViewHolder.txt_item_servNm.setText(Html.fromHtml(servName));

        // Html.fromHtml(Text) : 문자열에 포함된 HTML 코드를
        // 실제 기능으로 변환시키는 method
        goDataViewHolder.txt_item_servDgst.setText(Html.fromHtml( vo.getServDgst() ));
        String jurString = "주관청:<font color=blue>" + vo.getJurMnofNm() + "</font>";
        goDataViewHolder.txt_item_jurMnofNm.setText(Html.fromHtml(jurString)) ;
        goDataViewHolder.txt_item_servDtlLink.setText(vo.getServDtlLink());
        goDataViewHolder.go_link.setTag(vo.getServDtlLink());

        goDataViewHolder.go_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = (String)v.getTag();

                // activity를 하나 생성해서
                // activity에서 url 링크를 열기
//                Intent intent = new Intent(context, WebViewActivity.class);
//                intent.putExtra("HTML",url);
//                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return goDataLists.size();
    }

    /*
    private String servId;       //	서비스ID
    private String servNm;       //	서비스명
    private String jurMnofNm;    //	소관부처명
    private String jurOrgNm;     //	소관조직명
    private String inqNum;       //	조회수
    private String servDgst;     //	서비스 요약
    private String servDtlLink;  //	서비스상세링크
    private String svcfrstRegTs; //	서비스등록일
    */
    class GoDataViewHolder extends RecyclerView.ViewHolder {

        TextView txt_item_servNm ;
        TextView txt_item_jurMnofNm ;
        TextView txt_item_servDgst ;
        TextView txt_item_servDtlLink ;
        TextView go_link ;

        public GoDataViewHolder(View itemView) {
            super(itemView);

            context = itemView.getContext();

            txt_item_servNm = itemView.findViewById(R.id.item_txt_serv_nm);
            txt_item_jurMnofNm = itemView.findViewById(R.id.item_txt_jur_mnof_nm);
            txt_item_servDgst = itemView.findViewById(R.id.item_txt_serv_dgst);
            txt_item_servDtlLink = itemView.findViewById(R.id.item_txt_serv_dtl_link);
            go_link = itemView.findViewById(R.id.item_go_link);

        }
    }
}
