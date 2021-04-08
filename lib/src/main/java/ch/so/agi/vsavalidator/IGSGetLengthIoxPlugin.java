package ch.so.agi.vsavalidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import ch.ehi.basics.settings.Settings;
import ch.ehi.basics.types.OutParam;
import ch.interlis.ili2c.Ili2cException;
import ch.interlis.ili2c.metamodel.AbstractClassDef;
import ch.interlis.ili2c.metamodel.AssociationDef;
import ch.interlis.ili2c.metamodel.AssociationPath;
import ch.interlis.ili2c.metamodel.AttributeRef;
import ch.interlis.ili2c.metamodel.CompositionType;
import ch.interlis.ili2c.metamodel.EnumerationType;
import ch.interlis.ili2c.metamodel.LocalAttribute;
import ch.interlis.ili2c.metamodel.ObjectPath;
import ch.interlis.ili2c.metamodel.PathEl;
import ch.interlis.ili2c.metamodel.PathElAbstractClassRole;
import ch.interlis.ili2c.metamodel.PathElAssocRole;
import ch.interlis.ili2c.metamodel.PathElRefAttr;
import ch.interlis.ili2c.metamodel.PathElThis;
import ch.interlis.ili2c.metamodel.ReferenceType;
import ch.interlis.ili2c.metamodel.RoleDef;
import ch.interlis.ili2c.metamodel.StructAttributeRef;
import ch.interlis.ili2c.metamodel.TransferDescription;
import ch.interlis.ili2c.metamodel.Type;
import ch.interlis.ili2c.metamodel.TypeAlias;
import ch.interlis.ili2c.metamodel.Viewable;
import ch.interlis.ili2c.metamodel.ViewableTransferElement;
import ch.interlis.ili2c.parser.Ili23Parser;
import ch.interlis.iom.IomObject;
import ch.interlis.iom_j.Iom_jObject;
import ch.interlis.iox.IoxValidationConfig;
import ch.interlis.iox_j.logging.LogEventFactory;
import ch.interlis.iox_j.validator.InterlisFunction;
import ch.interlis.iox_j.validator.ObjectPool;
import ch.interlis.iox_j.validator.Value;
import ch.interlis.iox_j.validator.Validator;

public class IGSGetLengthIoxPlugin implements InterlisFunction {
    private LogEventFactory logger = null;
    private TransferDescription td = null;
    private ObjectPool objectPool = null;
    private HashMap<String, Viewable> tag2class = null;

    @Override
    public Value evaluate(String validationKind, String usageScope, IomObject mainObj, Value[] actualArguments) {
        if (actualArguments[0].skipEvaluation()) {
            return actualArguments[0];
        }
        if (actualArguments[1].skipEvaluation()) {
            return actualArguments[1];
        }
        if (actualArguments[0].isUndefined()) {
            return Value.createSkipEvaluation();
        }
        if (actualArguments[1].isUndefined()) {
            return Value.createSkipEvaluation();
        }

        System.out.println(actualArguments[0].getComplexObjects());
        System.out.println(actualArguments[1].getValue());
        
        // Um die Klasse zu bestimmen, kann ich das erste Objekt verwenden. Falls
        // es mehrere Objekte sind, sind es immer Objekte von der gleichen Klasse.
        IomObject iomObj = (IomObject) actualArguments[0].getComplexObjects().toArray()[0];
        Viewable currentClass = (Viewable) td.getElement(iomObj.getobjecttag());

        System.out.println(currentClass);
        
        ObjectPath attributePath = null;
        try {
            attributePath = ch.interlis.ili2c.Main.parseObjectOrAttributePath(currentClass,"Verlauf");
        } catch (Ili2cException e) {
            e.printStackTrace();
            logger.addEvent(logger.logErrorMsg("Could not parse object or attribute path."));
            return Value.createSkipEvaluation();
        }
        
        System.out.println(attributePath);
        
        Value valueOfObjectPath = this.getValueFromObjectPath(null, iomObj, attributePath.getPathElements(), null);

        System.out.println(valueOfObjectPath.getValue());
        System.out.println(valueOfObjectPath.isUndefined());
        System.out.println(valueOfObjectPath.getComplexObjects());
        
        
        // Siehe ilivalidator-custom-functions GeometryUtils, um
        // zu sehen wie mit den verschiedenen Möglichkeiten umgegangen
        // werden muss.
        // Zum jetzigen Zeitpunkt akzeptieren wir nur Geometrien,
        // wie sie im VSA-DSS-Mini kodiert sind.
        // Etwas für Geom.getLength() oder so.
        
        return Value.createSkipEvaluation();
        
        
//        IomObject startObj = (IomObject) actualArguments[0].getComplexObjects().toArray()[0];
//        IomObject endObj = (IomObject) actualArguments[1].getComplexObjects().toArray()[0];
//                
//        Double x1 = Double.parseDouble(startObj.getattrvalue("C1"));
//        Double y1 = Double.parseDouble(startObj.getattrvalue("C2"));
//        double z1 = 0;
//        if (startObj.getattrvalue("C3") != null) {
//            z1 = Double.parseDouble(startObj.getattrvalue("C3"));
//        }
//        
//        Double x2 = Double.parseDouble(endObj.getattrvalue("C1"));
//        Double y2 = Double.parseDouble(endObj.getattrvalue("C2"));
//        double z2 = 0;
//        if (endObj.getattrvalue("C3") != null) {
//            z2 = Double.parseDouble(endObj.getattrvalue("C3"));
//        }
//
//        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) + Math.pow(z2 - z1, 2));
//        return new Value(distance);
    }

    @Override
    public String getQualifiedIliName() {
        return "IGSFunction.IGS_getLength";
    }

    @Override
    public void init(TransferDescription td, Settings settings, 
            IoxValidationConfig validationConfig, ObjectPool objectPool, 
            LogEventFactory logEventFactory) {

        this.logger = logEventFactory;
        this.logger.setValidationConfig(validationConfig);
        this.td = td;
        this.objectPool = objectPool;
        this.tag2class = ch.interlis.iom_j.itf.ModelUtilities.getTagMap(td);        
    }
    
 
    
    private Value getValueFromObjectPath(IomObject parentObject, IomObject iomObjStart, PathEl[] pathElements,
            RoleDef firstRole) {
        ArrayList<IomObject> currentObjects = new ArrayList<IomObject>();
        ArrayList<IomObject> nextCurrentObjects = new ArrayList<IomObject>();
        RoleDef role = null;
        final int lastPathIndex = pathElements.length - 1;
        currentObjects.add(iomObjStart);
        for (int k = 0; k < pathElements.length; k++) {
            for (IomObject iomObj : currentObjects) {
                PathEl currentPathEl = pathElements[k];
                if (currentPathEl instanceof PathElAbstractClassRole || currentPathEl instanceof PathElAssocRole
                        || currentPathEl instanceof AssociationPath) {
                    if (currentPathEl instanceof PathElAbstractClassRole) {
                        PathElAbstractClassRole abstractClassRole = (PathElAbstractClassRole) currentPathEl;
                        role = (RoleDef) abstractClassRole.getRole();
                    } else if (currentPathEl instanceof PathElAssocRole) {
                        role = ((PathElAssocRole) currentPathEl).getRole();
                    } else if (currentPathEl instanceof AssociationPath) {
                        role = ((AssociationPath) currentPathEl).getTargetRole();
                    }

                    if (role == null) {
//                        throw new IllegalStateException(rsrc.getString("getValueFromObjectPath.roleIsNotBeEmpty"));
                    } else {
                        // IF embedded association and first PathEl of objectpath
                        if (parentObject != null && k == 0) {
                            // IF last PathEl of objectpath
                            if (k == lastPathIndex) {
                                // THEN return embedded reference object
                                if (role == firstRole) {
                                    nextCurrentObjects.add(iomObj);
                                } else {
                                    // create/return a reference object to parent object
                                    Iom_jObject ref = new Iom_jObject("REF", null);
                                    ref.setobjectrefoid(parentObject.getobjectoid());
                                    nextCurrentObjects.add(ref);
                                }
                            } else {
                                if (role == firstRole) {
                                    IomObject targetObj = getReferencedObject(role, iomObj.getobjectrefoid());
                                    nextCurrentObjects.add(targetObj);
                                } else {
                                    nextCurrentObjects.add(parentObject);
                                }
                            }
                        } else {
                            String targetOid = null;
                            IomObject roleDefValue = iomObj.getattrobj(role.getName(), 0);
                            if (roleDefValue != null) {
                                targetOid = roleDefValue.getobjectrefoid();
                            }
                            Viewable srcObjClass = (Viewable) tag2class.get(iomObj.getobjecttag());
                            if (isBackward(srcObjClass, role)) {
                                // has a linkObj?
                                List<IomObject> objects = null;
                                if (((AssociationDef) role.getContainer()).isLightweight()) {
                                    objects = getTargetObjectsOfReverseRole(role, iomObj.getobjectoid());
                                    if (objects != null) {
                                        nextCurrentObjects.addAll(objects);
                                    }
                                    continue;

                                } else {
                                    objects = getLinkObjects(role, iomObj.getobjectoid());
                                    if (objects != null) {
                                        if (currentPathEl instanceof PathElAssocRole
                                                || currentPathEl instanceof PathElAbstractClassRole) {
                                            for (IomObject obj : objects) {
                                                IomObject attrobj = obj.getattrobj(role.getName(), 0);
                                                IomObject targetObj = getReferencedObject(role,
                                                        attrobj.getobjectrefoid());
                                                if (targetObj != null) {
                                                    List<IomObject> objct = new ArrayList<IomObject>();
                                                    objct.add(targetObj);
                                                    if (k != lastPathIndex) {
                                                        nextCurrentObjects.add(targetObj);
                                                    } else {
                                                        nextCurrentObjects.addAll(objct);
                                                    }
                                                }
                                            }
                                        } else if (currentPathEl instanceof AssociationPath) {
                                            nextCurrentObjects.addAll(objects);
                                        }
                                    }
                                    continue;
                                }
                            }
                            if (k != lastPathIndex) {
                                IomObject targetObj = getReferencedObject(role, targetOid);
                                if (targetObj != null) {
                                    nextCurrentObjects.add(targetObj);
                                }
                            } else {
                                List<IomObject> objects = new ArrayList<IomObject>();
                                IomObject targetRefObj = getReferencedObject(role, targetOid);
                                if (targetRefObj != null) {
                                    if (role instanceof RoleDef) {
                                        return Value.createOidValue(targetRefObj.getobjectoid());
                                    } else {
                                        objects.add(targetRefObj);
                                        nextCurrentObjects.addAll(objects);
                                    }

                                } else if (roleDefValue != null) {
                                    objects.add(roleDefValue);
                                    nextCurrentObjects.addAll(objects);
                                }
                            }
                        }
                    }
                } else if (currentPathEl instanceof StructAttributeRef) {
                    StructAttributeRef structAttributeRefValue = (StructAttributeRef) currentPathEl;
                    if (structAttributeRefValue.getAttr() instanceof LocalAttribute) {
                        LocalAttribute localAttributeValue = (LocalAttribute) structAttributeRefValue.getAttr();
                        if (!(localAttributeValue.getDomain() instanceof CompositionType)) {
                            throw new IllegalStateException();
                        }

                        CompositionType type = (CompositionType) localAttributeValue.getDomain();
                        String currentAttrName = localAttributeValue.getName();
                        if (iomObj.getattrvaluecount(currentAttrName) != 0) {
                            IomObject targetObj = iomObj = getIomObjWithIndex(iomObj, structAttributeRefValue,
                                    currentAttrName);
                            if (k != lastPathIndex) {
                                nextCurrentObjects.add(targetObj);
                            } else {
                                String attrValue = iomObj.getattrvalue(currentAttrName);
                                if (attrValue != null) {
                                    if (attrValue.equals("true")) {
                                        return new Value(true);
                                    } else if (attrValue.equals("false")) {
                                        return new Value(false);
                                    } else {
                                        return new Value(type, attrValue);
                                    }
                                } else {
                                    List<IomObject> objects = new ArrayList<IomObject>();
                                    objects.add(targetObj);
                                    nextCurrentObjects.addAll(objects);
                                }
                            }
                        }
                    }
                } else if (currentPathEl instanceof AttributeRef) {
                    AttributeRef attrRef = (AttributeRef) currentPathEl;
                    Type type = attrRef.getAttr().getDomain();
                    String currentAttrName = currentPathEl.getName();
                    if (iomObj == null) {
                        return Value.createUndefined();
                    }
                    int attrCount = iomObj.getattrvaluecount(currentAttrName);
                    if (attrCount == 0) {
                        return Value.createUndefined();
                    } else {
                        // not the last pathEl?
                        if (k != lastPathIndex) {
                            for (int i = 0; i < attrCount; i++) {
                                IomObject iomObjTmp = iomObj.getattrobj(currentAttrName, i);
                                nextCurrentObjects.add(iomObjTmp);
                            }
                        } else {
                            String attrValue = iomObj.getattrvalue(currentAttrName);
                            if (attrValue != null) {
                                if (attrValue.equals("true")) {
                                    return new Value(true);
                                } else if (attrValue.equals("false")) {
                                    return new Value(false);
                                    // if null, then complex value.
                                } else {
                                    if (type instanceof TypeAlias) {
                                        Type aliasedType = ((TypeAlias) type).getAliasing().getType();
                                        if (aliasedType instanceof EnumerationType) {
                                            String refTypeName = ((TypeAlias) type).getAliasing().getName();
                                            return new Value(aliasedType, attrValue, refTypeName);
                                        }
                                        return new Value(aliasedType, attrValue);
                                    }
                                    if (type instanceof EnumerationType) {
                                        return new Value(type, attrValue);
                                    }
                                }
                                if (currentObjects.size() == 1) {
                                    return new Value(type, attrValue);
                                } else {
                                    String[] attrValues = new String[currentObjects.size()];
                                    int counter = 0;
                                    for (IomObject value : currentObjects) {
                                        attrValue = value.getattrvalue(currentAttrName);
                                        if (attrValue != null) {
                                            attrValues[counter] = attrValue;
                                            counter++;
                                        }
                                    }
                                    if (attrValues != null) {
                                        return new Value(type, attrValues);
                                    }
                                }

                            } else {
                                List<IomObject> objects = new ArrayList<IomObject>();
                                int attrValueCount = iomObj.getattrvaluecount(currentAttrName);
                                // iterate, because it's a list of attrObjects.
                                for (int i = 0; i < attrValueCount; i++) {
                                    objects.add(iomObj.getattrobj(currentAttrName, i));
                                }
                                nextCurrentObjects.addAll(objects);
                            }
                        }
                    }
                } else if (currentPathEl instanceof PathElRefAttr) {
                    PathElRefAttr pathElRefAttr = (PathElRefAttr) currentPathEl;

                    if (!(pathElRefAttr.getAttr() instanceof LocalAttribute)) {
                        throw new IllegalStateException();
                    }

                    LocalAttribute localAttributeValue = (LocalAttribute) pathElRefAttr.getAttr();
                    if (!(localAttributeValue.getDomain() instanceof ReferenceType)) {
                        throw new IllegalStateException();
                    }

                    ReferenceType referenceType = (ReferenceType) localAttributeValue.getDomain();

                    String targetOid = null;
                    IomObject tmpIomObject = iomObj.getattrobj(currentPathEl.getName(), 0);
                    if (tmpIomObject != null) {
                        targetOid = tmpIomObject.getobjectrefoid();
                    }

                    if (targetOid != null) {
                        IomObject targetObj = getIomObjectFromObjectPool(referenceType, targetOid);
                        if (targetObj != null) {
                            if (k != lastPathIndex) {
                                nextCurrentObjects.add(targetObj);
                            } else {
                                List<IomObject> objects = new ArrayList<IomObject>();
                                objects.add(targetObj);
                                nextCurrentObjects.addAll(objects);
                            }
                        }
                    }
                } else if (currentPathEl instanceof PathElThis) {
                    nextCurrentObjects.addAll(currentObjects);
                }

            }
            if (nextCurrentObjects.isEmpty()) {
                return Value.createUndefined();
            }
            if (k != lastPathIndex) {
                currentObjects = nextCurrentObjects;
                nextCurrentObjects = new ArrayList<IomObject>();
            } else {
                return new Value(nextCurrentObjects);
            }

        }
        return Value.createUndefined();
    }
    
    private boolean isBackward(Viewable srcObjClass, RoleDef role) {
        AssociationDef assoc=(AssociationDef) role.getContainer();
        if(assoc.isLightweight()) {
            // if reference is embedded in srcObj then is it a forward
            if (isRoleEmbedded(role) && role.getOppEnd().getDestination()==srcObjClass) {
                return true;
            } else {
                return false;
            }
        }else {
            // assoc has a link obj, is srcObj the link obj
            if(srcObjClass==assoc) {
                // role is forward; srcObj contains a reference
                return false;
            }
            // role is backward; srcObj doesn't contain a reference
            return true;
        }
    }

    private boolean isRoleEmbedded(RoleDef role) {
        Viewable destination = role.getDestination();
        Iterator iterator = destination.getAttributesAndRoles2();
        while (iterator.hasNext()) {
            ViewableTransferElement obj = (ViewableTransferElement)iterator.next();
            if (obj.obj instanceof RoleDef) {
                RoleDef objRole = ((RoleDef) obj.obj).getOppEnd();
                if (objRole.equals(role)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    private IomObject getIomObjectFromObjectPool(ReferenceType referenceType, String targetOid) {
        OutParam<String> bidOfTargetObj = new OutParam<String>();
        ArrayList<Viewable> destinationClasses=new ArrayList<Viewable>();
        destinationClasses.add(referenceType.getReferred());
        return (IomObject) this.objectPool.getObject(targetOid, destinationClasses, bidOfTargetObj);
    }
    
    private IomObject getReferencedObject(RoleDef role, String oid) {
        Iterator<AbstractClassDef> targetClassIterator = role.iteratorDestination();
        ArrayList<Viewable> destinationClasses = new ArrayList<Viewable>();
        // find target classes.
        while(targetClassIterator.hasNext()) {
            Viewable roleDestinationClass = (Viewable) targetClassIterator.next();
            destinationClasses.add(roleDestinationClass);
        }
        OutParam<String> bidOfTargetObj = new OutParam<String>();
        IomObject targetObj = (IomObject) objectPool.getObject(oid, destinationClasses, bidOfTargetObj);
        return targetObj;
    }

    private IomObject getIomObjWithIndex(IomObject iomObj, StructAttributeRef structAttributeRefValue, String currentAttrName) {
        int expectedIndex = (int) (long) structAttributeRefValue.getIndex();
        int attrValueCount = iomObj.getattrvaluecount(currentAttrName);
        if (structAttributeRefValue.getIndex() == structAttributeRefValue.eFIRST) {
            iomObj = iomObj.getattrobj(currentAttrName, 0);
        } else if (structAttributeRefValue.getIndex() == structAttributeRefValue.eLAST) {
            iomObj = iomObj.getattrobj(currentAttrName, attrValueCount - 1);
        } else {
            if (expectedIndex <= attrValueCount && expectedIndex > 0) {
                iomObj = iomObj.getattrobj(currentAttrName, expectedIndex - 1);
                if (iomObj == null) {
//                    throw new IllegalStateException(rsrc.getString("getIomObjWithIndex.thereIsNoRecordFoundForThisIndex"));
                }
            } else {
//                throw new IllegalStateException(rsrc.getString("getIomObjWithIndex.thereIsNoRecordFoundForThisIndex"));
            }
        }
        return iomObj;
    }

    private Map<RoleDef,Map<String,List<IomObject>>> linkObjects=new HashMap<RoleDef,Map<String,List<IomObject>>>();
    private List<IomObject> getLinkObjects(RoleDef role, String srcObjOid) {        
        if(!linkObjects.containsKey(role)) {
            buildLinkObjMap(role);
        }
        return linkObjects.get(role).get(srcObjOid);
    }
    private void buildLinkObjMap(RoleDef role) {     
        Map<String, List<IomObject>> values = new HashMap<String, List<IomObject>>();
        linkObjects.put(role, values);
        for (String basketId : objectPool.getBasketIds()) {
            Iterator<IomObject> objectIterator = (objectPool.getObjectsOfBasketId(basketId)).valueIterator();
            while (objectIterator.hasNext()) { 
                IomObject linkObj = objectIterator.next();
                if (((Viewable)tag2class.get(linkObj.getobjecttag())).isExtending(role.getContainer())) {
                    IomObject refStruct = linkObj.getattrobj(role.getOppEnd().getName(), 0);
                    if (refStruct!=null) {
                        List<IomObject> objects = values.get(refStruct.getobjectrefoid());
                        if (objects == null) {
                            objects = new ArrayList<IomObject>();
                            values.put(refStruct.getobjectrefoid(), objects);                            
                        }
                        objects.add(linkObj);
                    }
                }
            }
        }
    }
  
    private Map<RoleDef,Map<String,List<IomObject>>> targetObjects=new HashMap<RoleDef,Map<String,List<IomObject>>>();
    private List<IomObject> getTargetObjectsOfReverseRole(RoleDef role, String srcObjOid) {
        if(!targetObjects.containsKey(role)) {
            buildTargetObjectsMap(role);
        }
        return targetObjects.get(role).get(srcObjOid);
    }
    private void buildTargetObjectsMap(RoleDef role) {     
        Map<String, List<IomObject>> values = new HashMap<String, List<IomObject>>();
        targetObjects.put(role, values);
        for (String basketId : objectPool.getBasketIds()) {
            Iterator<IomObject> objectIterator = (objectPool.getObjectsOfBasketId(basketId)).valueIterator();
            while (objectIterator.hasNext()) { 
                IomObject targetObj = objectIterator.next();
                if (((Viewable)tag2class.get(targetObj.getobjecttag())).isExtending(role.getDestination())) {
                    IomObject refStruct = targetObj.getattrobj(role.getOppEnd().getName(), 0);
                    if (refStruct!=null) {
                        List<IomObject> objects = values.get(refStruct.getobjectrefoid());
                        if (objects == null) {
                            objects = new ArrayList<IomObject>();
                            values.put(refStruct.getobjectrefoid(), objects);                            
                        }
                        objects.add(targetObj);
                    }
                }
            }
        }
    }


}
