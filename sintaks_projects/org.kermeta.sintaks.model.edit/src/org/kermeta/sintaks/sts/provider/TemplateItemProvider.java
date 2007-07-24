/**
 * <copyright>
 * </copyright>
 *
 * $Id: TemplateItemProvider.java,v 1.2 2007-07-24 12:12:12 cfaucher Exp $
 */
package org.kermeta.sintaks.sts.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.sts.StsFactory;
import org.kermeta.sintaks.sts.StsPackage;
import org.kermeta.sintaks.sts.Template;

/**
 * This is the item provider adapter for a {@link org.kermeta.sintaks.sts.Template} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TemplateItemProvider
	extends RuleItemProvider
	implements	
		IEditingDomainItemProvider,	
		IStructuredItemContentProvider,	
		ITreeItemContentProvider,	
		IItemLabelProvider,	
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addMetaclassPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Metaclass feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMetaclassPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Template_metaclass_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Template_metaclass_feature", "_UI_Template_type"),
				 StsPackage.Literals.TEMPLATE__METACLASS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(StsPackage.Literals.TEMPLATE__RULE);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Template.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Template"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public String getText(Object object) {
        StringBuffer tmp = new StringBuffer();
        tmp.append(getString("_UI_Template_type"));
        String label = ((Rule)object).getId();
        if (label != null && label.length() != 0) {
            tmp.append(" ");
            tmp.append(label);
        }
        EClass c = ((Template)object).getMetaclass();
        if (c != null) {
        	String name = c.getName();
        	if (name != null && name.length() != 0) {
                tmp.append(" : ");
        		tmp.append(name);
        	}
		}
        return tmp.toString();
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Template.class)) {
			case StsPackage.TEMPLATE__METACLASS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case StsPackage.TEMPLATE__RULE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(StsPackage.Literals.TEMPLATE__RULE,
				 StsFactory.eINSTANCE.createSequence()));

		newChildDescriptors.add
			(createChildParameter
				(StsPackage.Literals.TEMPLATE__RULE,
				 StsFactory.eINSTANCE.createIteration()));

		newChildDescriptors.add
			(createChildParameter
				(StsPackage.Literals.TEMPLATE__RULE,
				 StsFactory.eINSTANCE.createAlternative()));

		newChildDescriptors.add
			(createChildParameter
				(StsPackage.Literals.TEMPLATE__RULE,
				 StsFactory.eINSTANCE.createOnce()));

		newChildDescriptors.add
			(createChildParameter
				(StsPackage.Literals.TEMPLATE__RULE,
				 StsFactory.eINSTANCE.createTerminal()));

		newChildDescriptors.add
			(createChildParameter
				(StsPackage.Literals.TEMPLATE__RULE,
				 StsFactory.eINSTANCE.createAdornment()));

		newChildDescriptors.add
			(createChildParameter
				(StsPackage.Literals.TEMPLATE__RULE,
				 StsFactory.eINSTANCE.createTemplate()));

		newChildDescriptors.add
			(createChildParameter
				(StsPackage.Literals.TEMPLATE__RULE,
				 StsFactory.eINSTANCE.createPrimitiveValue()));

		newChildDescriptors.add
			(createChildParameter
				(StsPackage.Literals.TEMPLATE__RULE,
				 StsFactory.eINSTANCE.createObjectReference()));

		newChildDescriptors.add
			(createChildParameter
				(StsPackage.Literals.TEMPLATE__RULE,
				 StsFactory.eINSTANCE.createRuleRef()));

		newChildDescriptors.add
			(createChildParameter
				(StsPackage.Literals.TEMPLATE__RULE,
				 StsFactory.eINSTANCE.createConstant()));

		newChildDescriptors.add
			(createChildParameter
				(StsPackage.Literals.TEMPLATE__RULE,
				 StsFactory.eINSTANCE.createURIValue()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return STSEditPlugin.INSTANCE;
	}

}
