package org.localizedmc.checklistlocalizer.mixin;

//import com.lclc98.checklist.loader.markdown.LinkElementMarkdown;
//import net.minecraft.text.Text;
//import org.objectweb.asm.Opcodes;
//import org.spongepowered.asm.mixin.Final;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Mutable;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Redirect;
//
//@Mixin(LinkElementMarkdown.class)
//public class LinkElementMarkdownMixin {
//    @Mutable
//    @Shadow(remap = false) @Final private String text;
//
//    @Redirect(method = "<init>", at = @At(value = "FIELD", target = "Lcom/lclc98/checklist/loader/markdown/LinkElementMarkdown;text:Ljava/lang/String;", opcode = Opcodes.PUTFIELD), remap = false)
//    private void injected(LinkElementMarkdown instance, String value) {
//        text = Text.translatable(value).getString();
//    }
//}
