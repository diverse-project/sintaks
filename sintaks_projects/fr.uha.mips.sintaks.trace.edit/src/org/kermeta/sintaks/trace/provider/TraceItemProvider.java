/**
 * <copyright>
 * </copyright>
 *
 * $Id: TraceItemProvider.java,v 1.1 2008-07-21 13:12:04 hassen Exp $
 */
package org.kermeta.sintaks.trace.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.kermeta.sintaks.trace.State;
import org.kermeta.sintaks.trace.Trace;
import org.kermeta.sintaks.trace.TraceFactory;
import org.kermeta.sintaks.trace.TracePackage;

/**
 * This is the item provider adapter for a {@link org.kermeta.sintaks.trace.Trace} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TraceItemProvider
	extends ItemProviderAdapter
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
	public TraceItemProvider(AdapterFactory adapterFactory) {
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

			addStatePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the State feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Trace_state_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Trace_state_feature", "_UI_Trace_type"),
				 TracePackage.Literals.TRACE__STATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
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
			childrenFeatures.add(TracePackage.Literals.TRACE__SOURCE_REFERENCE);
			childrenFeatures.add(TracePackage.Literals.TRACE__TARGET_REFERENCE);
			childrenFeatures.add(TracePackage.Literals.TRACE__RULE_REFERENCE);
			childrenFeatures.add(TracePackage.Literals.TRACE__DESCRIPTION);
			childrenFeatures.add(TracePackage.Literals.TRACE__SUB_TRACES);
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
	 * This returns Trace.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Trace"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		State labelValue = ((Trace)object).getState();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_Trace_type") :
			getString("_UI_Trace_type") + " " + label;
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

		switch (notification.getFeatureID(Trace.class)) {
			case TracePackage.TRACE__STATE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case TracePackage.TRACE__SOURCE_REFERENCE:
			case TracePackage.TRACE__TARGET_REFERENCE:
			case TracePackage.TRACE__RULE_REFERENCE:
			case TracePackage.TRACE__DESCRIPTION:
			case TracePackage.TRACE__SUB_TRACES:
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
				(TracePackage.Literals.TRACE__SOURCE_REFERENCE,
				 TraceFactory.eINSTANCE.createTextReference()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.TRACE__SOURCE_REFERENCE,
				 TraceFactory.eINSTANCE.createModelReference()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.TRACE__SOURCE_REFERENCE,
				 TraceFactory.eINSTANCE.createFileReference()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.TRACE__TARGET_REFERENCE,
				 TraceFactory.eINSTANCE.createTextReference()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.TRACE__TARGET_REFERENCE,
				 TraceFactory.eINSTANCE.createModelReference()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.TRACE__TARGET_REFERENCE,
				 TraceFactory.eINSTANCE.createFileReference()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.TRACE__RULE_REFERENCE,
				 TraceFactory.eINSTANCE.createTextReference()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.TRACE__RULE_REFERENCE,
				 TraceFactory.eINSTANCE.createModelReference()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.TRACE__RULE_REFERENCE,
				 TraceFactory.eINSTANCE.createFileReference()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.TRACE__DESCRIPTION,
				 TraceFactory.eINSTANCE.createMessage()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.TRACE__SUB_TRACES,
				 TraceFactory.eINSTANCE.createTrace()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == TracePackage.Literals.TRACE__SOURCE_REFERENCE ||
			childFeature == TracePackage.Literals.TRACE__TARGET_REFERENCE ||
			childFeature == TracePackage.Literals.TRACE__RULE_REFERENCE;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return TraceEditPlugin.INSTANCE;
	}

}
