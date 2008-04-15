/**
 * <copyright>
 * </copyright>
 *
 * $Id: RootItemProvider.java,v 1.3 2008-04-15 14:23:46 hassen Exp $
 */
package org.kermeta.sintaks.sts.provider;


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

import org.kermeta.sintaks.sts.Root;
import org.kermeta.sintaks.sts.StsFactory;
import org.kermeta.sintaks.sts.StsPackage;

/**
 * This is the item provider adapter for a {@link org.kermeta.sintaks.sts.Root} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RootItemProvider
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
	public RootItemProvider(AdapterFactory adapterFactory) {
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

			addStartPropertyDescriptor(object);
			addStringDelimliterPropertyDescriptor(object);
			addEscapeCharacterPropertyDescriptor(object);
			addEolCommentPropertyDescriptor(object);
			addBlockCommentStartPropertyDescriptor(object);
			addBlockCommentEndPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Start feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStartPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Root_start_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Root_start_feature", "_UI_Root_type"),
				 StsPackage.Literals.ROOT__START,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the String Delimliter feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStringDelimliterPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Root_stringDelimliter_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Root_stringDelimliter_feature", "_UI_Root_type"),
				 StsPackage.Literals.ROOT__STRING_DELIMLITER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.TEXT_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Escape Character feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEscapeCharacterPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Root_escapeCharacter_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Root_escapeCharacter_feature", "_UI_Root_type"),
				 StsPackage.Literals.ROOT__ESCAPE_CHARACTER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.TEXT_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Eol Comment feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEolCommentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Root_eolComment_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Root_eolComment_feature", "_UI_Root_type"),
				 StsPackage.Literals.ROOT__EOL_COMMENT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Block Comment Start feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBlockCommentStartPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Root_blockCommentStart_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Root_blockCommentStart_feature", "_UI_Root_type"),
				 StsPackage.Literals.ROOT__BLOCK_COMMENT_START,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Block Comment End feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBlockCommentEndPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Root_blockCommentEnd_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Root_blockCommentEnd_feature", "_UI_Root_type"),
				 StsPackage.Literals.ROOT__BLOCK_COMMENT_END,
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
			childrenFeatures.add(StsPackage.Literals.ROOT__FRAGMENTS);
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
	 * This returns Root.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Root"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		Root root = (Root)object;
		return getString("_UI_Root_type") + " " + root.getStringDelimliter();
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

		switch (notification.getFeatureID(Root.class)) {
			case StsPackage.ROOT__STRING_DELIMLITER:
			case StsPackage.ROOT__ESCAPE_CHARACTER:
			case StsPackage.ROOT__EOL_COMMENT:
			case StsPackage.ROOT__BLOCK_COMMENT_START:
			case StsPackage.ROOT__BLOCK_COMMENT_END:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case StsPackage.ROOT__FRAGMENTS:
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
				(StsPackage.Literals.ROOT__FRAGMENTS,
				 StsFactory.eINSTANCE.createSequence()));

		newChildDescriptors.add
			(createChildParameter
				(StsPackage.Literals.ROOT__FRAGMENTS,
				 StsFactory.eINSTANCE.createIteration()));

		newChildDescriptors.add
			(createChildParameter
				(StsPackage.Literals.ROOT__FRAGMENTS,
				 StsFactory.eINSTANCE.createAlternative()));

		newChildDescriptors.add
			(createChildParameter
				(StsPackage.Literals.ROOT__FRAGMENTS,
				 StsFactory.eINSTANCE.createOnce()));

		newChildDescriptors.add
			(createChildParameter
				(StsPackage.Literals.ROOT__FRAGMENTS,
				 StsFactory.eINSTANCE.createTerminal()));

		newChildDescriptors.add
			(createChildParameter
				(StsPackage.Literals.ROOT__FRAGMENTS,
				 StsFactory.eINSTANCE.createAdornment()));

		newChildDescriptors.add
			(createChildParameter
				(StsPackage.Literals.ROOT__FRAGMENTS,
				 StsFactory.eINSTANCE.createTemplate()));

		newChildDescriptors.add
			(createChildParameter
				(StsPackage.Literals.ROOT__FRAGMENTS,
				 StsFactory.eINSTANCE.createPrimitiveValue()));

		newChildDescriptors.add
			(createChildParameter
				(StsPackage.Literals.ROOT__FRAGMENTS,
				 StsFactory.eINSTANCE.createObjectReference()));

		newChildDescriptors.add
			(createChildParameter
				(StsPackage.Literals.ROOT__FRAGMENTS,
				 StsFactory.eINSTANCE.createRuleRef()));

		newChildDescriptors.add
			(createChildParameter
				(StsPackage.Literals.ROOT__FRAGMENTS,
				 StsFactory.eINSTANCE.createConstant()));

		newChildDescriptors.add
			(createChildParameter
				(StsPackage.Literals.ROOT__FRAGMENTS,
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
