package org.eclipse.xtext.example.domainmodel.jvmmodel;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.example.domainmodel.domainmodel.AbstractElement;
import org.eclipse.xtext.example.domainmodel.domainmodel.DomainModel;
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity;
import org.eclipse.xtext.example.domainmodel.domainmodel.Feature;
import org.eclipse.xtext.example.domainmodel.domainmodel.Import;
import org.eclipse.xtext.example.domainmodel.domainmodel.Operation;
import org.eclipse.xtext.example.domainmodel.domainmodel.PackageDeclaration;
import org.eclipse.xtext.example.domainmodel.domainmodel.Property;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociator;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.JvmVisibilityExtension;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class DomainmodelJvmModelInferrer implements IJvmModelInferrer {
  private final DomainmodelJvmModelInferrer _this = this;
  @com.google.inject.Inject private TypesFactory typesFactory;
  @com.google.inject.Inject private IJvmModelAssociator iJvmModelAssociator;
  @com.google.inject.Inject private JvmVisibilityExtension jvmVisibilityExtension;
  
  public List<EObject> inferJvmModel(final EObject sourceObject) {
    Iterable<EObject> _transform = _this.transform(sourceObject);
    List<EObject> _list = IterableExtensions.toList(_transform);
    return _list;
  }
  
  public Iterable<EObject> _transform(final DomainModel model) {
    EList<AbstractElement> _elements = model.getElements();
    final Function1<AbstractElement,Iterable<EObject>> function = new Function1<AbstractElement,Iterable<EObject>>() {
        public Iterable<EObject> apply(AbstractElement e) {
          final AbstractElement final_e = (AbstractElement)e;
          Iterable<EObject> _transform = _this.transform(final_e);
          return _transform;
        }
      };
    List<Iterable<EObject>> _map = ListExtensions.map(_elements, function);
    Iterable<EObject> _flatten = IterableExtensions.flatten(_map);
    return _flatten;
  }
  
  public Iterable<EObject> _transform(final PackageDeclaration packageDecl) {
    EList<AbstractElement> _elements = packageDecl.getElements();
    final Function1<AbstractElement,Iterable<EObject>> function = new Function1<AbstractElement,Iterable<EObject>>() {
        public Iterable<EObject> apply(AbstractElement e) {
          final AbstractElement final_e = (AbstractElement)e;
          Iterable<EObject> _transform = _this.transform(final_e);
          return _transform;
        }
      };
    List<Iterable<EObject>> _map = ListExtensions.map(_elements, function);
    Iterable<EObject> _flatten = IterableExtensions.flatten(_map);
    return _flatten;
  }
  
  public Iterable<EObject> _transform(final Entity entity) {
    ArrayList<EObject> _xblockexpression = null;
    {
      TypesFactory _typesFactory = _this.typesFactory;
      JvmGenericType _createJvmGenericType = _typesFactory.createJvmGenericType();
      final JvmGenericType jvmClass = _createJvmGenericType;
      String _name = entity.getName();
      jvmClass.setSimpleName(_name);
      final Entity final_entity = (Entity)entity;
      String _packageName = _this.packageName(final_entity);
      jvmClass.setPackageName(_packageName);
      IJvmModelAssociator _iJvmModelAssociator = iJvmModelAssociator;
      final Entity final_entity_1 = (Entity)entity;
      final JvmGenericType final_jvmClass = (JvmGenericType)jvmClass;
      _iJvmModelAssociator.associatePrimary(final_entity_1, final_jvmClass);
      JvmVisibilityExtension _jvmVisibilityExtension = jvmVisibilityExtension;
      final JvmGenericType final_jvmClass_1 = (JvmGenericType)jvmClass;
      _jvmVisibilityExtension.setPublic(final_jvmClass_1);
      EList<Feature> _features = entity.getFeatures();
      final Function1<Feature,Void> function = new Function1<Feature,Void>() {
          public Void apply(Feature feature) {
            _this.transform(feature, jvmClass);
            return null;
          }
        };
      IterableExtensions.forEach(_features, function);
      ArrayList<EObject> _newArrayList = CollectionLiterals.newArrayList(((org.eclipse.emf.ecore.EObject) jvmClass));
      _xblockexpression = (_newArrayList);
    }
    return _xblockexpression;
  }
  
  public Iterable<EObject> _transform(final Import importDecl) {
    ArrayList<EObject> _newArrayList = CollectionLiterals.newArrayList();
    return _newArrayList;
  }
  
  public Iterable<EObject> _transform(final Void nothing) {
    ArrayList<EObject> _newArrayList = CollectionLiterals.newArrayList();
    return _newArrayList;
  }
  
  public void _transform(final Property property, final JvmGenericType type) {
    {
      TypesFactory _typesFactory = _this.typesFactory;
      JvmField _createJvmField = _typesFactory.createJvmField();
      final JvmField jvmField = _createJvmField;
      final Property final_property = (Property)property;
      String _name = final_property.getName();
      jvmField.setSimpleName(_name);
      final Property final_property_1 = (Property)property;
      JvmParameterizedTypeReference _type = final_property_1.getType();
      JvmParameterizedTypeReference _cloneWithProxies = EcoreUtil2.cloneWithProxies(_type);
      jvmField.setType(_cloneWithProxies);
      JvmVisibilityExtension _jvmVisibilityExtension = jvmVisibilityExtension;
      final JvmField final_jvmField = (JvmField)jvmField;
      _jvmVisibilityExtension.setPrivate(final_jvmField);
      final JvmGenericType final_type = (JvmGenericType)type;
      EList<JvmMember> _members = final_type.getMembers();
      CollectionExtensions.operator_add(_members, jvmField);
      IJvmModelAssociator _iJvmModelAssociator = iJvmModelAssociator;
      final Property final_property_2 = (Property)property;
      final JvmField final_jvmField_1 = (JvmField)jvmField;
      _iJvmModelAssociator.associatePrimary(final_property_2, final_jvmField_1);
      TypesFactory _typesFactory_1 = _this.typesFactory;
      JvmOperation _createJvmOperation = _typesFactory_1.createJvmOperation();
      final JvmOperation jvmGetter = _createJvmOperation;
      final Property final_property_3 = (Property)property;
      String _name_1 = final_property_3.getName();
      String _firstUpper = StringExtensions.toFirstUpper(_name_1);
      String _operator_plus = StringExtensions.operator_plus("get", _firstUpper);
      jvmGetter.setSimpleName(_operator_plus);
      final Property final_property_4 = (Property)property;
      JvmParameterizedTypeReference _type_1 = final_property_4.getType();
      JvmParameterizedTypeReference _cloneWithProxies_1 = EcoreUtil2.cloneWithProxies(_type_1);
      jvmGetter.setReturnType(_cloneWithProxies_1);
      JvmVisibilityExtension _jvmVisibilityExtension_1 = jvmVisibilityExtension;
      final JvmOperation final_jvmGetter = (JvmOperation)jvmGetter;
      _jvmVisibilityExtension_1.setPublic(final_jvmGetter);
      final JvmGenericType final_type_1 = (JvmGenericType)type;
      EList<JvmMember> _members_1 = final_type_1.getMembers();
      CollectionExtensions.operator_add(_members_1, jvmGetter);
      IJvmModelAssociator _iJvmModelAssociator_1 = iJvmModelAssociator;
      final Property final_property_5 = (Property)property;
      final JvmOperation final_jvmGetter_1 = (JvmOperation)jvmGetter;
      _iJvmModelAssociator_1.associatePrimary(final_property_5, final_jvmGetter_1);
      TypesFactory _typesFactory_2 = _this.typesFactory;
      JvmOperation _createJvmOperation_1 = _typesFactory_2.createJvmOperation();
      final JvmOperation jvmSetter = _createJvmOperation_1;
      final Property final_property_6 = (Property)property;
      String _name_2 = final_property_6.getName();
      String _firstUpper_1 = StringExtensions.toFirstUpper(_name_2);
      String _operator_plus_1 = StringExtensions.operator_plus("set", _firstUpper_1);
      jvmSetter.setSimpleName(_operator_plus_1);
      TypesFactory _typesFactory_3 = _this.typesFactory;
      JvmFormalParameter _createJvmFormalParameter = _typesFactory_3.createJvmFormalParameter();
      final JvmFormalParameter parameter = _createJvmFormalParameter;
      final Property final_property_7 = (Property)property;
      String _name_3 = final_property_7.getName();
      String _firstUpper_2 = StringExtensions.toFirstUpper(_name_3);
      parameter.setName(_firstUpper_2);
      final Property final_property_8 = (Property)property;
      JvmParameterizedTypeReference _type_2 = final_property_8.getType();
      JvmParameterizedTypeReference _cloneWithProxies_2 = EcoreUtil2.cloneWithProxies(_type_2);
      parameter.setParameterType(_cloneWithProxies_2);
      JvmVisibilityExtension _jvmVisibilityExtension_2 = jvmVisibilityExtension;
      final JvmOperation final_jvmSetter = (JvmOperation)jvmSetter;
      _jvmVisibilityExtension_2.setPublic(final_jvmSetter);
      final JvmOperation final_jvmSetter_1 = (JvmOperation)jvmSetter;
      EList<JvmFormalParameter> _parameters = final_jvmSetter_1.getParameters();
      CollectionExtensions.operator_add(_parameters, parameter);
      final JvmGenericType final_type_2 = (JvmGenericType)type;
      EList<JvmMember> _members_2 = final_type_2.getMembers();
      CollectionExtensions.operator_add(_members_2, jvmSetter);
      IJvmModelAssociator _iJvmModelAssociator_2 = iJvmModelAssociator;
      final Property final_property_9 = (Property)property;
      final JvmOperation final_jvmSetter_2 = (JvmOperation)jvmSetter;
      _iJvmModelAssociator_2.associatePrimary(final_property_9, final_jvmSetter_2);
    }
  }
  
  public void _transform(final Operation operation, final JvmGenericType type) {
    {
      TypesFactory _typesFactory = _this.typesFactory;
      JvmOperation _createJvmOperation = _typesFactory.createJvmOperation();
      final JvmOperation jvmOperation = _createJvmOperation;
      final Operation final_operation = (Operation)operation;
      String _name = final_operation.getName();
      jvmOperation.setSimpleName(_name);
      final Operation final_operation_1 = (Operation)operation;
      JvmParameterizedTypeReference _type = final_operation_1.getType();
      JvmParameterizedTypeReference _cloneWithProxies = EcoreUtil2.cloneWithProxies(_type);
      jvmOperation.setReturnType(_cloneWithProxies);
      final JvmOperation final_jvmOperation = (JvmOperation)jvmOperation;
      EList<JvmFormalParameter> _parameters = final_jvmOperation.getParameters();
      EList<JvmFormalParameter> _params = operation.getParams();
      final Function1<JvmFormalParameter,JvmFormalParameter> function = new Function1<JvmFormalParameter,JvmFormalParameter>() {
          public JvmFormalParameter apply(JvmFormalParameter p) {
            JvmFormalParameter _cloneWithProxies_1 = EcoreUtil2.cloneWithProxies(p);
            return _cloneWithProxies_1;
          }
        };
      List<JvmFormalParameter> _map = ListExtensions.map(_params, function);
      _parameters.addAll(_map);
      JvmVisibilityExtension _jvmVisibilityExtension = jvmVisibilityExtension;
      final JvmOperation final_jvmOperation_1 = (JvmOperation)jvmOperation;
      _jvmVisibilityExtension.setPublic(final_jvmOperation_1);
      final JvmGenericType final_type = (JvmGenericType)type;
      EList<JvmMember> _members = final_type.getMembers();
      CollectionExtensions.operator_add(_members, jvmOperation);
      IJvmModelAssociator _iJvmModelAssociator = iJvmModelAssociator;
      final Operation final_operation_2 = (Operation)operation;
      final JvmOperation final_jvmOperation_2 = (JvmOperation)jvmOperation;
      _iJvmModelAssociator.associatePrimary(final_operation_2, final_jvmOperation_2);
    }
  }
  
  public String packageName(final EObject o) {
    String switchResult = null;
    final EObject o_1 = o;
    boolean matched = false;
    if (!matched) {
      if (o_1 instanceof Entity) {
        final Entity o_2 = (Entity) o_1;
        matched=true;
        final Entity final_o_2 = (Entity)o_2;
        EObject _eContainer = final_o_2.eContainer();
        String _packageName = _this.packageName(_eContainer);
        switchResult = _packageName;
      }
    }
    if (!matched) {
      if (o_1 instanceof PackageDeclaration) {
        final PackageDeclaration o_3 = (PackageDeclaration) o_1;
        matched=true;
        final PackageDeclaration final_o_3 = (PackageDeclaration)o_3;
        EObject _eContainer_1 = final_o_3.eContainer();
        String _packageName_1 = _this.packageName(_eContainer_1);
        String _name = o_3.getName();
        String _concatPath = _this.concatPath(_packageName_1, _name);
        switchResult = _concatPath;
      }
    }
    if (!matched) {
      switchResult = null;
    }
    return switchResult;
  }
  
  public String concatPath(final String x, final String y) {
    String _xifexpression = null;
    boolean _operator_equals = ObjectExtensions.operator_equals(x, null);
    if (((Boolean)_operator_equals)) {
      _xifexpression = y;
    } else {
      String _operator_plus = StringExtensions.operator_plus(x, ".");
      final String final_y = (String)y;
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, final_y);
      _xifexpression = _operator_plus_1;
    }
    return _xifexpression;
  }
  
  public Iterable<EObject> transform(final EObject packageDecl) {
    if ((packageDecl instanceof Entity)) {
      return _transform((Entity)packageDecl);
    } else if ((packageDecl instanceof Import)) {
      return _transform((Import)packageDecl);
    } else if ((packageDecl instanceof PackageDeclaration)) {
      return _transform((PackageDeclaration)packageDecl);
    } else if ((packageDecl instanceof DomainModel)) {
      return _transform((DomainModel)packageDecl);
    } else if ((packageDecl == null)) {
      return _transform((Void)null);
    } else {
      throw new IllegalArgumentException();
    }
  }
  
  public void transform(final Feature property, final JvmGenericType type) {
    if ((property instanceof Operation)
         && (type instanceof JvmGenericType)) {
      _transform((Operation)property, (JvmGenericType)type);
    } else if ((property instanceof Property)
         && (type instanceof JvmGenericType)) {
      _transform((Property)property, (JvmGenericType)type);
    } else {
      throw new IllegalArgumentException();
    }
  }
}