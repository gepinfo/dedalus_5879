import { Component, OnInit, ViewChild } from '@angular/core';
import { HospitalorderlistService } from './hospitalorderlist.service';

import { NzMessageService } from 'ng-zorro-antd/message';
import { NzTableFilterFn, NzTableFilterList, NzTableSortFn, NzTableSortOrder } from 'ng-zorro-antd/table';
import { NzSelectSizeType } from 'ng-zorro-antd/select';



@Component({
  selector: 'app-hospitalorderlist',
  templateUrl: './hospitalorderlist.component.html',
  styleUrls: ['./hospitalorderlist.component.scss'],
})

export class HospitalorderlistComponent implements OnInit {
    public hospitalorderlist:any = {
        created_date: '',
        created_by: '',
        last_modified_by: '',
        last_modified_date: '',
        orderID: '',
        speciemanNo: '',
        patientID: '',
        facility: '',
        episodeType: '',
        episodeID: '',
        doctor: '',
        type: '',
        code: '',
        ps: '',
    }

    isVisibleCreate = false;
    isVisibleUpdate = false;
    size: NzSelectSizeType = 'default';




    constructor (
        private nzMessageService: NzMessageService,
        private hospitalorderlistService: HospitalorderlistService,
    ) { }

    ngOnInit() {
        this.GetAllValues();
        this.hospitalorderlist.created_by = sessionStorage.getItem('email') || ''; 
        


    
    }

   showModal(): void {
    this.isVisibleCreate = true;
   }

  handleOk(): void {
 
    this.isVisibleCreate = false;
    this.isVisibleUpdate = false;
  }

  handleCancel(): void {
 
    this.isVisibleCreate = false;
    this.isVisibleUpdate = false;
  }



  modalpopup: boolean = false;
  Updatemodalpopup: boolean = false;
  show:any = -999;
  deleteshow:any;

       Create() {
      this.isVisibleCreate = false;
        this.hospitalorderlistService.PostAllhospitalorderlistValues(this.hospitalorderlist).subscribe((data:any) => {
            this.hospitalorderlist.orderID = '',
            this.hospitalorderlist.speciemanNo = '',
            this.hospitalorderlist.patientID = '',
            this.hospitalorderlist.facility = '',
            this.hospitalorderlist.episodeType = '',
            this.hospitalorderlist.episodeID = '',
            this.hospitalorderlist.doctor = '',
            this.hospitalorderlist.type = '',
            this.hospitalorderlist.code = '',
            this.hospitalorderlist.ps = '',
            this.GetAllValues();
        },
        (error:Error) => {
            console.log('Error', error);
        });
    }

    filterStatus = [
      { text: 'Active', value: 'ACTIVE' },
      { text: 'In-Active', value: 'INACTIVE' }
    ];
  
    filterAccessProfile = [
      { text: 'Receptionist', value: 'Receptionist' },
      { text: 'Health Care Provide', value: 'Health Care Provide' }
    ]
  
    
  
    listOfData: any[] = [];

    Update() {
        this.hospitalorderlistService.Updatehospitalorderlist(this.hospitalorderlist).subscribe((data:any) => {
            this.hospitalorderlist.orderID = '';
            this.hospitalorderlist.speciemanNo = '';
            this.hospitalorderlist.patientID = '';
            this.hospitalorderlist.facility = '';
            this.hospitalorderlist.episodeType = '';
            this.hospitalorderlist.episodeID = '';
            this.hospitalorderlist.doctor = '';
            this.hospitalorderlist.type = '';
            this.hospitalorderlist.code = '';
            this.hospitalorderlist.ps = '';
            this.GetAllValues();
            this.isVisibleUpdate = false;
        },
        (error:Error) => {
            console.log('Error', error);
        });
    }
    Delete(deleteid:any) {
        this.hospitalorderlistService.DeletehospitalorderlistValues(deleteid).subscribe((data:any) => {
            this.GetAllValues();
        },
        (error:Error) => {
            console.log('Error', error);
        });
    }

    GetAllValues() {
        this.hospitalorderlistService.GetAllhospitalorderlistValues().subscribe((data: any) => {
            this.listOfData = data;
            console.log(data);
        },
        (error: Error) => {
            console.log('Error', error);
        });
    }


    search(search:any){
    if(search.length >= 2){
        const targetValue: any[] = [];
        this.listOfData.forEach((value: any) => {
            let keys = Object.keys(value);
            for (let i = 0; i < keys.length; i++) {
                if (value[keys[i]] && value[keys[i]].toString().toLocaleLowerCase().includes(search)) {
                    targetValue.push(value);
                    break;
                }
            }
        });
        this.listOfData = targetValue;
        } else {
            this.GetAllValues();
        }
    }


    cancel(): void {
        this.nzMessageService.info('click cancel');
    }

    confirmDelete(data:any): void {
        this.nzMessageService.info('click confirm');
        this.Delete(data.id);
    }

  openModal() {
    this.modalpopup = true;
  }

  updateModelPopup(){
    this.Updatemodalpopup = true;
  }

  deleteShow(index:any){
    this.deleteshow = index;
  }

  deleteConfirm(data:any){
    this.Delete(data.id);
    this.deleteshow = -999
  }

    getUpdateById(data:any){
        this.isVisibleUpdate = true;
        this.hospitalorderlist = data;
    }
}





