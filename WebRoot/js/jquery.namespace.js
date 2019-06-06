jQuery.namespace = function() {  
    var a=arguments, o=null, i, j, d;  
    for (i=0; i<a.length; i=i+1) {  
        d=a[i].split(".");  
        o=window;  
        for (j=0; j<d.length; j=j+1) {  
            o[d[j]]=o[d[j]] || {};  
            o=o[d[j]];  
        }  
    }  
    return o;  
};


jQuery.namespace('BMEP.Dic');
jQuery.namespace('BMEP.DicClass');
jQuery.namespace('BMEP.Base.Subject');
jQuery.namespace('BMEP.Base.Subject.Show');
jQuery.namespace('BMEP.Base.Country');
jQuery.namespace('BMEP.Base.Country.Show');
jQuery.namespace('BMEP.Base.Template');
jQuery.namespace('BMEP.Client.ClientInfo.Tree');
jQuery.namespace('BMEP.Order.Preorder');

/**********发票***************/
jQuery.namespace('BMEP.Invoice.Invoice');
jQuery.namespace('BMEP.Invoice.MatchBookList');
jQuery.namespace('BMEP.Invoice.MatchBookListDetail');
jQuery.namespace('BMEP.Invoice.InvoiceShow');
jQuery.namespace('BMEP.Invoice.Inspection');
jQuery.namespace('BMEP.Invoice.DetailShow');
jQuery.namespace('BMEP.Invoice.InvoiceCn');
jQuery.namespace('BMEP.Invoice.SaleInvoice');
jQuery.namespace('BMEP.Invoice.Stock');
jQuery.namespace('BMEP.Invoice.Collect');
/**********发票***************/
/**********人员信息***************/
jQuery.namespace('BMEP.Person.SysAccount');
jQuery.namespace('BMEP.Person.PersonType');
jQuery.namespace('BMEP.Person.PPersonTypePropClassify');
jQuery.namespace('BMEP.Person.PPersonTypeProp');
jQuery.namespace('BMEP.Person.PPersonInfo');
jQuery.namespace('BMEP.Person.PPosition');
jQuery.namespace('BMEP.Person.PersonInfo.GetAccount');
/**********人员信息***************/
/**********产品信息***************/
jQuery.namespace('BMEP.Product.ProductType.Tree');
jQuery.namespace('BMEP.Product.ProductInfo');
jQuery.namespace( 'BMEP.Product.ProductTypeProp' );
jQuery.namespace('BMEP.Product.PTypePropClassify');
jQuery.namespace('BMEP.Product.ProductInfo.updateMarc');
jQuery.namespace('Editorial.ProductType.Licence');
/**********产品信息***************/
/**********客户信息***************/
jQuery.namespace('BMEP.Client.Event');
jQuery.namespace('BMEP.Client.Service' );
jQuery.namespace('BMEP.Client.PriceModulus' );
jQuery.namespace('BMEP.Client.Transaction' );
jQuery.namespace('BMEP.Client.ClientType.Prop');
jQuery.namespace( 'BMEP.Client.ClientType' );
jQuery.namespace('BMEP.Client.Classify');
jQuery.namespace('BMEP.Client.Account');
jQuery.namespace('BMEP.Account.PPersonInfo');
jQuery.namespace('BMEP.Client.Transport');
/**********客户信息***************/
/**********订单信息***************/
jQuery.namespace('BMEP.Order.SaleOrder');
jQuery.namespace('BMEP.Order.SaleItem');
jQuery.namespace('BMEP.Order.Tree');
jQuery.namespace('BMEP.Order.SalePack.Tree');
jQuery.namespace('BMEP.Order.SalePack');
jQuery.namespace('BMEP.New.SalePack');
jQuery.namespace('BMEP.SalePack.PUItem');
jQuery.namespace('BMEP.Sale.Release');
jQuery.namespace('BMEP.Sale.Release.ConfirmTransport');
jQuery.namespace('BMEP.Sale.Release.CreateTransportOrder');
jQuery.namespace('BMEP.Sale.Release.Detail');
jQuery.namespace('BMEP.Sale.Transport');
jQuery.namespace('BMEP.Sale.Transport.Detail');
/**********订单信息***************/
/**********采购信息***************/
jQuery.namespace('BMEP.Purchase.Order');
jQuery.namespace('BMEP.Purchase.Item');
jQuery.namespace('BMEP.Order.SaleItem.PrePurchase');
/**********采购信息***************/
jQuery.namespace('BMEP.Base.Currency');
jQuery.namespace('BMEP.Person.Corp.Account');
jQuery.namespace('BMEP.Person.Corp');
/**********汇总信息***************/
jQuery.namespace('BMEP.Sum.Sale');
jQuery.namespace('BMEP.Sum.SaleExport');
/**********汇总信息***************/
/**********Global配置***********/
jQuery.namespace( 'BMEP.Global.GlobalType' );
jQuery.namespace('BMEP.Global.Classify');
jQuery.namespace('BMEP.Global.TypeProp');
/*************库存**************/
jQuery.namespace('BMEP.Inventory');
jQuery.namespace('BMEP.InStorage');
/*************库存**************/
jQuery.namespace('BMEP.Invoice.PreCheckIn');
jQuery.namespace('BMEP.Invoice.CheckIn');
jQuery.namespace('BMEP.Invoice.Abnormal');
jQuery.namespace('BMEP.Inventory.CheckOut');
jQuery.namespace('BMEP.Inventory.OutStorageDetail');
jQuery.namespace('BMEP.Inventory.CheckOutDetail');
jQuery.namespace('BMEP.Inventory.PreCheckOutDetail');

jQuery.namespace('BMEP.TAttachment');
/*************知识体系**************/
jQuery.namespace('Editorial.knowledgeHierarchy.Tree');

/*************流程**************/
jQuery.namespace('Editorial.JBPM.Deploy');
jQuery.namespace('Editorial.JBPM.task');
jQuery.namespace('Editorial.Flow');
jQuery.namespace('Editorial.JBPM.Design');
jQuery.namespace('Editorial.JBPM.Design.Dic');
jQuery.namespace('Editorial.JBPM.Design.Prop');
jQuery.namespace('Editorial.JBPM.ProductType');
jQuery.namespace('Editorial.JBPM.ProcessDefine');
jQuery.namespace('Editorial.Flow.taskRepo');
jQuery.namespace('Editorial.Flow.processRepo');
jQuery.namespace('Editorial.Flow.processDesign');
/*************流程**************/


jQuery.namespace('Editorial.Material');
jQuery.namespace('Editorial.CopyRight');
jQuery.namespace('Editorial.Attach');
jQuery.namespace('Editorial.Person.Author');
jQuery.namespace('Editorial.Cost');
jQuery.namespace('Editorial.PrintCosts');
jQuery.namespace('Editorial.Product.Subject');
jQuery.namespace('Editorial.Price');
jQuery.namespace('Editorial.PriceDiscount');
jQuery.namespace('Editorial.Check');

jQuery.namespace('Editorial.CRM.PersonType');
jQuery.namespace('Editorial.CRM.PersonTypePropClassify');
jQuery.namespace('Editorial.CRM.PersonTypeProp');
jQuery.namespace('Editorial.CRM.PersonInfo');
jQuery.namespace('Editorial.CRM.PersonInfo.SysAccount')
jQuery.namespace('Editorial.CRM.CorpType');
jQuery.namespace('Editorial.CRM.CorpTypePropClassify');
jQuery.namespace('Editorial.Product.ProductType');


jQuery.namespace('Editorial.Product.ProductInfo');
jQuery.namespace('WebGate.ResourcePage');
jQuery.namespace('Editorial.IvSite.filter');
jQuery.namespace('WebGate.ResourceRole');
jQuery.namespace('WebGate.ResourcePage');

jQuery.namespace('Editorial.Plugins.Mail');
jQuery.namespace('Editorial.Contract');


/*************资源管理**************/
jQuery.namespace('ZongJu.User');
jQuery.namespace('ZongJu.Copyright');
jQuery.namespace('ZongJu.Compress');
jQuery.namespace('ZongJu.Watermark');
jQuery.namespace('ZongJu.PublishTrade');
jQuery.namespace('PUP.Base.News.Show');
