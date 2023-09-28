package com.enderdragons.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modeldragonwings<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("enderdragons", "modeldragonwings"), "main");
	public final ModelPart head;
	public final ModelPart spine;
	public final ModelPart jaw;
	public final ModelPart body;
	public final ModelPart left_wing;
	public final ModelPart left_wing_tip;
	public final ModelPart right_wing;
	public final ModelPart right_wing_tip;
	public final ModelPart front_left_leg;
	public final ModelPart front_left_shin;
	public final ModelPart front_left_foot;
	public final ModelPart back_left_leg;
	public final ModelPart back_left_shin;
	public final ModelPart back_left_foot;
	public final ModelPart front_right_leg;
	public final ModelPart front_right_shin;
	public final ModelPart front_right_foot;
	public final ModelPart back_right_leg;
	public final ModelPart back_right_shin;
	public final ModelPart back_right_foot;

	public Modeldragonwings(ModelPart root) {
		this.head = root.getChild("head");
		this.spine = root.getChild("spine");
		this.jaw = root.getChild("jaw");
		this.body = root.getChild("body");
		this.left_wing = root.getChild("left_wing");
		this.left_wing_tip = root.getChild("left_wing_tip");
		this.right_wing = root.getChild("right_wing");
		this.right_wing_tip = root.getChild("right_wing_tip");
		this.front_left_leg = root.getChild("front_left_leg");
		this.front_left_shin = root.getChild("front_left_shin");
		this.front_left_foot = root.getChild("front_left_foot");
		this.back_left_leg = root.getChild("back_left_leg");
		this.back_left_shin = root.getChild("back_left_shin");
		this.back_left_foot = root.getChild("back_left_foot");
		this.front_right_leg = root.getChild("front_right_leg");
		this.front_right_shin = root.getChild("front_right_shin");
		this.front_right_foot = root.getChild("front_right_foot");
		this.back_right_leg = root.getChild("back_right_leg");
		this.back_right_shin = root.getChild("back_right_shin");
		this.back_right_foot = root.getChild("back_right_foot");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition spine = partdefinition.addOrReplaceChild("spine", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition jaw = partdefinition.addOrReplaceChild("jaw", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -56.6F, -16.0F, 24.0F, 24.0F, 64.0F, new CubeDeformation(0.0F)).texOffs(220, 53)
						.addBox(-1.0F, -62.6F, -10.0F, 2.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(220, 53)
						.addBox(-1.0F, -62.6F, 10.0F, 2.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(220, 53)
						.addBox(-1.0F, -62.6F, 30.0F, 2.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 4.0F, 8.0F));
		PartDefinition tail1 = body
				.addOrReplaceChild("tail1",
						CubeListBuilder.create().texOffs(192, 104).addBox(-5.0F, -61.6F, 0.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
								.texOffs(48, 0).addBox(-1.0F, -65.6F, 2.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)),
						PartPose.offset(0.0F, 6.0F, 48.0F));
		PartDefinition tail2 = tail1
				.addOrReplaceChild("tail2",
						CubeListBuilder.create().texOffs(192, 104).addBox(-5.0F, -61.6F, 0.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
								.texOffs(48, 0).addBox(-1.0F, -65.6F, 2.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)),
						PartPose.offset(0.0F, 0.0F, 10.0F));
		PartDefinition tail3 = tail2
				.addOrReplaceChild("tail3",
						CubeListBuilder.create().texOffs(192, 104).addBox(-5.0F, -61.6F, 0.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
								.texOffs(48, 0).addBox(-1.0F, -65.6F, 2.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)),
						PartPose.offset(0.0F, 0.0F, 10.0F));
		PartDefinition tail4 = tail3
				.addOrReplaceChild("tail4",
						CubeListBuilder.create().texOffs(192, 104).addBox(-5.0F, -61.6F, 0.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
								.texOffs(48, 0).addBox(-1.0F, -65.6F, 2.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)),
						PartPose.offset(0.0F, 0.0F, 10.0F));
		PartDefinition tail5 = tail4
				.addOrReplaceChild("tail5",
						CubeListBuilder.create().texOffs(192, 104).addBox(-5.0F, -61.6F, 0.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
								.texOffs(48, 0).addBox(-1.0F, -65.6F, 2.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)),
						PartPose.offset(0.0F, 0.0F, 10.0F));
		PartDefinition tail6 = tail5
				.addOrReplaceChild("tail6",
						CubeListBuilder.create().texOffs(192, 104).addBox(-5.0F, -61.6F, 0.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
								.texOffs(48, 0).addBox(-1.0F, -65.6F, 2.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)),
						PartPose.offset(0.0F, 0.0F, 10.0F));
		PartDefinition tail7 = tail6.addOrReplaceChild(
				"tail7", CubeListBuilder.create().texOffs(48, 0).addBox(-1.0F, -65.6F, 2.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
						.texOffs(192, 104).addBox(-5.0F, -61.6F, 0.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 10.0F));
		PartDefinition tail8 = tail7
				.addOrReplaceChild("tail8",
						CubeListBuilder.create().texOffs(192, 104).addBox(-5.0F, -61.6F, 0.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
								.texOffs(48, 0).addBox(-1.0F, -65.6F, 2.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)),
						PartPose.offset(0.0F, 0.0F, 10.0F));
		PartDefinition tail9 = tail8
				.addOrReplaceChild("tail9",
						CubeListBuilder.create().texOffs(192, 104).addBox(-5.0F, -61.6F, 0.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
								.texOffs(48, 0).addBox(-1.0F, -65.6F, 2.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)),
						PartPose.offset(0.0F, 0.0F, 10.0F));
		PartDefinition tail10 = tail9
				.addOrReplaceChild("tail10",
						CubeListBuilder.create().texOffs(192, 104).addBox(-5.0F, -61.6F, 0.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
								.texOffs(48, 0).addBox(-1.0F, -65.6F, 2.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)),
						PartPose.offset(0.0F, 0.0F, 10.0F));
		PartDefinition tail11 = tail10
				.addOrReplaceChild("tail11",
						CubeListBuilder.create().texOffs(192, 104).addBox(-5.0F, -61.6F, 0.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
								.texOffs(48, 0).addBox(-1.0F, -65.6F, 2.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)),
						PartPose.offset(0.0F, 0.0F, 10.0F));
		PartDefinition tail12 = tail11
				.addOrReplaceChild("tail12",
						CubeListBuilder.create().texOffs(192, 104).addBox(-5.0F, -61.6F, 0.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
								.texOffs(48, 0).addBox(-1.0F, -65.6F, 2.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)),
						PartPose.offset(0.0F, 0.0F, 10.0F));
		PartDefinition neck1 = body.addOrReplaceChild("neck1", CubeListBuilder.create(), PartPose.offset(0.0F, 15.0F, -16.0F));
		PartDefinition neck2 = neck1.addOrReplaceChild("neck2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -10.0F));
		PartDefinition neck3 = neck2.addOrReplaceChild("neck3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -10.0F));
		PartDefinition neck4 = neck3.addOrReplaceChild("neck4", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -10.0F));
		PartDefinition neck5 = neck4.addOrReplaceChild("neck5", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -10.0F));
		PartDefinition head2 = neck5.addOrReplaceChild("head2", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, -10.0F));
		PartDefinition mirror = head2.addOrReplaceChild("mirror", CubeListBuilder.create(), PartPose.offset(0.0F, 6.0F, 58.0F));
		PartDefinition jaw2 = head2.addOrReplaceChild("jaw2", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, -14.0F));
		PartDefinition left_wing = partdefinition.addOrReplaceChild("left_wing", CubeListBuilder.create(), PartPose.offset(12.0F, 5.0F, 2.0F));
		PartDefinition left_wing_tip = partdefinition.addOrReplaceChild("left_wing_tip", CubeListBuilder.create(),
				PartPose.offset(68.0F, 5.0F, 2.0F));
		PartDefinition right_wing = partdefinition.addOrReplaceChild("right_wing", CubeListBuilder.create(), PartPose.offset(-12.0F, 5.0F, 2.0F));
		PartDefinition right_wing_tip = partdefinition.addOrReplaceChild("right_wing_tip", CubeListBuilder.create(),
				PartPose.offset(-68.0F, 5.0F, 2.0F));
		PartDefinition front_left_leg = partdefinition.addOrReplaceChild("front_left_leg",
				CubeListBuilder.create().texOffs(112, 104).addBox(-4.0F, -60.6F, -4.0F, 8.0F, 24.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offset(12.0F, 20.0F, 2.0F));
		PartDefinition front_left_shin = partdefinition.addOrReplaceChild("front_left_shin",
				CubeListBuilder.create().texOffs(226, 138).addBox(-3.0F, -57.6F, -3.0F, 6.0F, 24.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(12.0F, 41.0F, 2.0F));
		PartDefinition front_left_foot = partdefinition.addOrReplaceChild("front_left_foot",
				CubeListBuilder.create().texOffs(144, 104).addBox(-3.0F, -56.6F, -12.0F, 8.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offset(11.0F, 64.0F, 2.0F));
		PartDefinition back_left_leg = partdefinition.addOrReplaceChild("back_left_leg",
				CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -60.6F, -8.0F, 16.0F, 32.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offset(16.0F, 16.0F, 42.0F));
		PartDefinition back_left_shin = partdefinition.addOrReplaceChild("back_left_shin",
				CubeListBuilder.create().texOffs(196, 0).addBox(-6.0F, -58.6F, 0.0F, 12.0F, 32.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offset(16.0F, 46.0F, 36.0F));
		PartDefinition back_left_foot = partdefinition.addOrReplaceChild("back_left_foot",
				CubeListBuilder.create().texOffs(112, 0).addBox(-9.0F, -56.6F, -20.0F, 18.0F, 6.0F, 24.0F, new CubeDeformation(0.0F)),
				PartPose.offset(16.0F, 76.0F, 44.0F));
		PartDefinition front_right_leg = partdefinition.addOrReplaceChild("front_right_leg",
				CubeListBuilder.create().texOffs(112, 104).addBox(-4.0F, -60.6F, -4.0F, 8.0F, 24.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-12.0F, 20.0F, 2.0F));
		PartDefinition front_right_shin = partdefinition.addOrReplaceChild("front_right_shin",
				CubeListBuilder.create().texOffs(226, 138).addBox(-3.0F, -57.6F, -3.0F, 6.0F, 24.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-12.0F, 41.0F, 2.0F));
		PartDefinition front_right_foot = partdefinition.addOrReplaceChild("front_right_foot",
				CubeListBuilder.create().texOffs(144, 104).addBox(-4.0F, -56.6F, -12.0F, 8.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-12.0F, 64.0F, 2.0F));
		PartDefinition back_right_leg = partdefinition.addOrReplaceChild("back_right_leg",
				CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -60.6F, -8.0F, 16.0F, 32.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-16.0F, 16.0F, 42.0F));
		PartDefinition back_right_shin = partdefinition.addOrReplaceChild("back_right_shin",
				CubeListBuilder.create().texOffs(196, 0).addBox(-6.0F, -58.6F, 0.0F, 12.0F, 32.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-16.0F, 46.0F, 36.0F));
		PartDefinition back_right_foot = partdefinition.addOrReplaceChild("back_right_foot",
				CubeListBuilder.create().texOffs(112, 0).addBox(-9.0F, -56.6F, -20.0F, 18.0F, 6.0F, 24.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-16.0F, 76.0F, 44.0F));
		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spine.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		jaw.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_wing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_wing_tip.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_wing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_wing_tip.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		front_left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		front_left_shin.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		front_left_foot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		back_left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		back_left_shin.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		back_left_foot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		front_right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		front_right_shin.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		front_right_foot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		back_right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		back_right_shin.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		back_right_foot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
