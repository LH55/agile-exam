package com.qt.datasupply.controller;

import java.util.List;

public class PaginationHelper<I> {

    private List<I> list=null;
    private int itemsPerPage=0;

        public PaginationHelper(List<I> collection, int itemsPerPage) {
            this.list=collection;
            this.itemsPerPage=itemsPerPage;
        }


        public int itemCount() {
            return list.size();
        }


        public int pageCount() {
            int s = list.size();
            if(s==0||this.itemsPerPage==0)return -1;
            int i=s/this.itemsPerPage;
            if(s%this.itemsPerPage!=0)return i+1;
            return i;
        }

        public int pageItemCount(int pageIndex) {
            int count=pageCount();
            if(pageIndex+1>count)return -1;
            else if(pageIndex+1==count){
                int s=this.list.size();
                if(s<this.itemsPerPage) return s;
                else return(s-this.itemsPerPage*pageIndex);
            }
            else return this.itemsPerPage ;
        }

        public int pageIndex(int itemIndex) {
            if(itemIndex<0 || itemIndex>this.list.size()-1)return -1;
            return itemIndex/this.itemsPerPage;
        }

}
