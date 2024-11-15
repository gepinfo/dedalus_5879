import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExternalpatientlistComponent } from './externalpatientlist.component';
import { ExternalpatientlistService } from './externalpatientlist.service'
import { of, throwError } from 'rxjs';
import { SharedService } from 'src/shared/shared.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { HttpClient } from '@angular/common/http';
import { NgSelectModule } from '@ng-select/ng-select';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ExternalpatientlistComponent } from './externalpatientlist.component';


describe('ExternalpatientlistComponent', () => {
  let component: ExternalpatientlistComponent;
  let fixture: ComponentFixture<ExternalpatientlistComponent>;
  let service: ExternalpatientlistService;
  let sharedServiceMock = jasmine.createSpyObj('SharedService', ['methodName1', 'methodName2']);
  let httpClient: HttpClientTestingModule;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, 
        FormsModule, ReactiveFormsModule,
      ],
      declarations: [ ExternalpatientlistComponent ],
      providers: [ ExternalpatientlistService, 
        { provide: SharedService, useValue: sharedServiceMock},
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExternalpatientlistComponent);
    component = fixture.componentInstance;
    service = TestBed.inject(ExternalpatientlistService);
    httpClient = TestBed.inject(HttpClient);
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  // ngOnInit application onload
  it('should set the created_by property with the value from sessionStorage', () => {
    const mockEmail = 'test@example.com';
    spyOn(sessionStorage, 'getItem').and.returnValue(mockEmail);
    component.ngOnInit();

    expect(sessionStorage.getItem).toHaveBeenCalledWith('email');
    expect(component.externalpatientlist.created_by).toEqual(mockEmail);

  });
  


});